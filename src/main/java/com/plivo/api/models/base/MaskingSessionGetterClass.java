package com.plivo.api.models.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.plivo.api.models.maskingsession.MaskingSession;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Gets an instance of a resource.
 *
 * @param <T> The type of the resource.
 */
public abstract class MaskingSessionGetterClass<T extends BaseResource> extends BaseRequest<T> {

  protected final String id;
  public MaskingSessionGetterClass(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  /**
   * Actually get an instance of the resource.
   */
  public String get() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<T> response = obtainCall().execute();

    if(response.code()>=500){
      response = obtainFallback1Call().execute();
      if(response.code()>=500){
        response = obtainFallback2Call().execute();
      }
    }

    handleResponse(response);
    T responseBody = response.body();
    MaskingSession maskingSession = (MaskingSession) responseBody;
    Map<String, Object> newResponse = new HashMap<>();
    newResponse.put("api_id", maskingSession.getApiId());
    newResponse.put("response", maskingSession.getResponse());
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(newResponse);
  }

  @Override
  public MaskingSessionGetterClass<T> client(final PlivoClient plivoClient) {
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