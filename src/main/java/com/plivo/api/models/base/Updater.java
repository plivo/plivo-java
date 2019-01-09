package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.Client;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

@JsonInclude(Include.NON_NULL)
public abstract class Updater<T extends BaseResponse> extends BaseRequest {

  protected String id;

  public Updater(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  /**
   * Actually update the resource.
   */
  public T update() throws IOException, PlivoRestException {
    validate();
    Response<T> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  @Override
  public Updater<T> client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }


  protected abstract Call<T> obtainCall();
}
