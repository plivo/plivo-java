package com.plivo.api.models.base;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.powerpack.NumberPool;
import com.plivo.api.models.powerpack.Powerpack;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Map;

/**
 * Gets an instance of a resource.
 *
 * @param <T> The type of the resource.
 */
public abstract class PpkGetter<T extends BaseResource> extends BaseRequest<T> {

  protected final String id;

  public PpkGetter(String id) {
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
    try {
      Powerpack powerpack = (Powerpack) response.body();
      String numberpoolid = powerpack.getNumber_pool().split("/")[5];
      powerpack.numberpool = new NumberPool(numberpoolid);
    } catch (Exception e) {
//      /
    }
    return response.body();
  }

  @Override
  public PpkGetter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  protected Map<String, Object> toMap() {
    client();
    return Utils.objectToMap(PlivoClient.getObjectMapper(), this);
  }

  protected abstract Call<T> obtainCall();
}
