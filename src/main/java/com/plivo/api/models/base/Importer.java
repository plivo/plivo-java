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
 * @param <ImportResponse> The type of the response.
 */
@JsonInclude(Include.NON_NULL)
public abstract class Importer<ImportResponse extends BaseResponse> extends BaseRequest {

  /**
   * Actually import an instance of the resource.
   */
  public ImportResponse import_campaign() throws IOException, PlivoRestException {
    validate();
    Response<ImportResponse> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  @Override
  public Importer<ImportResponse> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<ImportResponse> obtainCall();
}
