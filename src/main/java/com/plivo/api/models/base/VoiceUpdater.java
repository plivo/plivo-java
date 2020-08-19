package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

@JsonInclude(Include.NON_NULL)
public abstract class VoiceUpdater<T extends BaseResponse> extends BaseRequest {

  protected String id;

  public VoiceUpdater(String id) {
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
    String identifier = this.id;
    Response<T> response = obtainCall(identifier).execute();

    if(response.code()>=500){
      response = obtainFallback1Call(identifier).execute();
      if(response.code()>=500){
        response = obtainFallback2Call(identifier).execute();
      }
    }

    handleResponse(response);

    return response.body();
  }

  @Override
  public VoiceUpdater<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<T> obtainCall(String identifier);
  protected abstract Call<T> obtainFallback1Call(String identifier);
  protected abstract Call<T> obtainFallback2Call(String identifier);
}
