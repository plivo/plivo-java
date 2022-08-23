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
public abstract class MessagingDeleter<T extends BaseResource> extends BaseRequest {

  protected String id;
  protected String secondaryId;

  public MessagingDeleter(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public MessagingDeleter(String id, String secondaryId) {
    if (id == null || secondaryId == null) {
      throw new IllegalArgumentException("id/secondaryId cannot be null");
    }
    this.id = id;
    this.secondaryId = secondaryId;
  }

  /**
   * Actually delete the resource.
   */
  public T delete() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<T> response = obtainCall().execute();

    handleResponse(response);

    return response.body();
  }
  @Override                  
  public MessagingDeleter<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;                                
    return this;                                                   
  }                                                                
                                                                   
                                                                   
  protected abstract Call<T> obtainCall() throws PlivoValidationException;
}