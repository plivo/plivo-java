package com.plivo.api.models.application;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApplicationDeleter extends Deleter<Application> {

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
   * @param Specify newEndpointApplication to be associated with endpoints
   */
  public ApplicationDeleter newEndpointApplication(final String newEndpointApplication) {
    this.newEndpointApplication = newEndpointApplication;
    return this;
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().applicationDelete(client().getAuthId(), id, this);
  }
}
