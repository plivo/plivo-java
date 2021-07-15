package com.plivo.api.models.base;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import java.util.Map;

import com.plivo.api.util.Utils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Gets an instance of a resource.
 *
 * @param <T> The type of the resource.
 */
public abstract class VoiceGetter<T extends BaseResource> extends BaseRequest<T> {

  protected final String id;
  protected String secondaryId;

  public VoiceGetter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public VoiceGetter(String id, String secondaryId) {
    if (id == null || secondaryId == null) {
      throw new IllegalArgumentException("id/secondaryId cannot be null");
    }
    this.id = id;
    this.secondaryId = secondaryId;
  }

  /**
   * Actually get an instance of the resource.
   */
  public T get() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<T> response = obtainCall().execute();

    if(response.code()>=500){
      response = obtainFallback1Call().execute();
      if(response.code()>=500){
        response = obtainFallback2Call().execute();
      }
    }

    handleResponse(response);

    return response.body();
  }

  @Override
  public VoiceGetter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  protected Map<String, Object> toMap() {
    client();
    return Utils.objectToMap(PlivoClient.getObjectMapper(), this);
  }

  protected abstract Call<T> obtainCall()  throws PlivoValidationException;
  protected abstract Call<T> obtainFallback1Call()  throws PlivoValidationException;
  protected abstract Call<T> obtainFallback2Call()  throws PlivoValidationException;
}