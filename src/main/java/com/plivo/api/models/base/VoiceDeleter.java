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
public abstract class VoiceDeleter<T extends BaseResource> extends BaseRequest<T> {

  protected String id;
  protected String secondaryId;
  public VoiceDeleter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public VoiceDeleter(String id, String secondaryId) {
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

    if(response.code()>=500){
      response = obtainFallback1Call().execute();
      if(response.code()>=500){
        response = obtainFallback2Call().execute();
      }
    }

    handleResponse(response);
  }

  @Override
  public VoiceDeleter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<ResponseBody> obtainCall() throws PlivoValidationException;
  protected abstract Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException;
  protected abstract Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException;
}