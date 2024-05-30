package com.plivo.api.models.base;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public abstract class MaskingSessionDeleterClass<T extends BaseResource> extends BaseRequest<T> {

  protected String id;
  protected String secondaryId;
  public MaskingSessionDeleterClass(String id) {
    this.id = id;

    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
  }

  public MaskingSessionDeleterClass(String id, String secondaryId) {
    if (id == null || secondaryId == null) {
      throw new IllegalArgumentException("id/secondaryId cannot be null");
    }
    this.id = id;
    this.secondaryId = secondaryId;
  }

  /**
   * Actually delete the resource.
   *
   * @return
   */
  public String delete() throws IOException, PlivoRestException, PlivoValidationException {
    validate();
    Response<ResponseBody> response = obtainCall().execute();

    if (response.code() >= 500) {
      response = obtainFallback1Call().execute();
      if (response.code() >= 500) {
        response = obtainFallback2Call().execute();
      }
    }
    int responseCode = response.code();
    if (responseCode == 400 || responseCode == 401 || responseCode == 404 || responseCode == 405 || responseCode == 500) {
      if (response.errorBody() != null) {
        throw new IOException(response.errorBody().string());
      } else {
        throw new PlivoRestException("Unexpected error with response code: " + responseCode);
      }
    } else {
      if (response.body() != null) {
        throw new IOException(response.body().string());
      } else {
        throw new PlivoRestException("Empty response body with response code: " + responseCode);
      }
    }
  }


  @Override
  public MaskingSessionDeleterClass<T> client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


  protected abstract Call<ResponseBody> obtainCall() throws PlivoValidationException;
  protected abstract Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException;
  protected abstract Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException;
}
