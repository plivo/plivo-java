package com.plivo.api.models.base;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Deletes an instance of a resource.
 *
 * @param <T> The type of the resource.
 */
public abstract class Deleter<T extends BaseResource> extends BaseRequest<T> {

  protected String id;
  protected String secondaryId;

  public Deleter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public Deleter(String id, String secondaryId) {
    if (id == null || secondaryId == null) {
      throw new IllegalArgumentException("id/secondaryId cannot be null");
    }
    this.id = id;
    this.secondaryId = secondaryId;
  }

  /**
   * Actually delete the resource.
   */
  public void delete() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<ResponseBody> response = obtainCall().execute();

    handleResponse(response);
  }

  @Override
  public Deleter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<ResponseBody> obtainCall() throws PlivoValidationException;
}
