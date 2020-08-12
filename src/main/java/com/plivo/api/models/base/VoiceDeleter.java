package com.plivo.api.models.base;

import com.plivo.api.PlivoClient;
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

  public VoiceDeleter(String id) {
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


  protected abstract Call<ResponseBody> obtainCall();
  protected abstract Call<ResponseBody> obtainFallback1Call();
  protected abstract Call<ResponseBody> obtainFallback2Call();
}