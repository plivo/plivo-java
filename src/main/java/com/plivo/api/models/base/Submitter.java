package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@JsonInclude(Include.NON_NULL)
public abstract class Submitter<T extends BaseResponse> extends BaseRequest {

  protected String id;

  public Submitter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  /**
   * Actually update the resource.
   */
  public T submit() throws IOException, PlivoRestException {
    validate();
    Response<T> response = obtainCall().execute();
    handleResponse(response);
    return response.body();
  }

  @Override
  public Submitter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<T> obtainCall();
}
