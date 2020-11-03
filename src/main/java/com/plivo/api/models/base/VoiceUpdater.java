package com.plivo.api.models.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;

@JsonInclude(Include.NON_NULL)
public abstract class VoiceUpdater<T extends BaseResponse> extends BaseRequest {

  @JsonIgnore
  protected String id;
  @JsonIgnore
  protected String secondaryId;

  public VoiceUpdater(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public VoiceUpdater(String id, String secondaryId) {
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
  public VoiceUpdater<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<T> obtainCall() throws PlivoValidationException;
  protected abstract Call<T> obtainFallback1Call() throws PlivoValidationException;
  protected abstract Call<T> obtainFallback2Call() throws PlivoValidationException;
}