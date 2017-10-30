package com.plivo.api.models.base;

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

  public Deleter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  /**
   * Actually delete the resource.
   */
  public void delete() throws IOException, PlivoRestException {
    validate();
    Response<ResponseBody> response = obtainCall().execute();

    handleResponse(response);
  }

  protected abstract Call<ResponseBody> obtainCall();
}
