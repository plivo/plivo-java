package com.plivo.api.models.base;

import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Gets an instance of a resource.
 *
 * @param <T> The type of the resource.
 */
public abstract class Getter<T extends BaseResource> extends BaseRequest<T> {

  protected final String id;

  public Getter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  /**
   * Actually get an instance of the resource.
   */
  public T get() throws IOException, PlivoRestException {
    validate();
    Response<T> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }

  protected abstract Call<T> obtainCall();
}
