package com.plivo.api.models.application;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class ApplicationLister extends VoiceLister<Application> {

  private String subaccount;

  private String appName;

  public String subaccount() {
    return this.subaccount;
  }

  public ApplicationLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }
  public String appName() {
    return this.appName;
  }

  public ApplicationLister appName(final String appName) {
    this.appName = appName;
    return this;
  }


  @Override
  protected Call<ListResponse<Application>> obtainCall() {
    return client().getVoiceApiService().applicationList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Application>> obtainFallback1Call() {
    return client().getVoiceFallback1Service().applicationList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Application>> obtainFallback2Call() {
    return client().getVoiceFallback2Service().applicationList(client().getAuthId(), toMap());
  }
}