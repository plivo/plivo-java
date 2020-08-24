package com.plivo.api.models.application;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApplicationDeleter extends VoiceDeleter<Application> {

  private Boolean cascade;
  private String newEndpointApplication;

  public ApplicationDeleter(String id) {
    super(id);
    cascade = true;
  }

  /**
   * @return Specify if the subaccount should be cascade deleted or not.
   */
  public Boolean cascade() {
    return this.cascade;
  }

  /**
   * @return newEndpointApplication to be associated with associated endpoints
   */
  public String newEndpointApplication() {
    return this.newEndpointApplication;
  }

  /**
   * @param cascade Specify if the subaccount should be cascade or not.
   */
  public ApplicationDeleter cascade(final Boolean cascade) {
    this.cascade = cascade;
    return this;
  }

  /**
   * @param newEndpointApplication to be associated with endpoints
   */
  public ApplicationDeleter newEndpointApplication(final String newEndpointApplication) {
    this.newEndpointApplication = newEndpointApplication;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().applicationDelete(client().getAuthId(), id, this);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().applicationDelete(client().getAuthId(), id, this);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().applicationDelete(client().getAuthId(), id, this);
  }
}