package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

@JsonInclude(Include.NON_NULL)
public abstract class Updater<T extends BaseResponse> extends BaseRequest {

  @JsonIgnore
  protected String id;
  @JsonIgnore
  protected String secondaryId;

  public Updater(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public Updater(String id, String secondaryId) {
    if (id == null || secondaryId == null) {
      throw new IllegalArgumentException("id/secondaryId cannot be null");
    }

    this.id = id;
    this.secondaryId = secondaryId;
  }

  /**
   * Actually update the resource.
   */
  public T update() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<T> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  @Override
  public Updater<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<T> obtainCall() throws PlivoValidationException;
}
