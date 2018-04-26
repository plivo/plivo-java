package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Creates an instance of a resource.
 *
 * @param <CreateResponse> The type of the response.
 */
@JsonInclude(Include.NON_NULL)
public abstract class Creator<CreateResponse extends BaseResponse> extends BaseRequest {

  /**
   * Actually create an instance of the resource.
   */
  public CreateResponse create() throws IOException, PlivoRestException {
    validate();
    Response<CreateResponse> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  @Override
  public Creator<CreateResponse> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<CreateResponse> obtainCall();
}
