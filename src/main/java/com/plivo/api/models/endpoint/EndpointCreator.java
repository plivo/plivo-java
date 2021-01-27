package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.VoiceCreator;
import retrofit2.Call;

public class EndpointCreator extends VoiceCreator<EndpointCreateResponse> {

  private final String username;
  private final String password;
  private final String alias;
  private String appId;

  public EndpointCreator(String username, String password, String alias) {
    this.username = username;
    this.password = password;
    this.alias = alias;
  }

  public String appId() {
    return this.appId;
  }

  public EndpointCreator appId(final String appId) {
    this.appId = appId;
    return this;
  }

  @Override
  protected Call<EndpointCreateResponse> obtainCall() {
    return client().getVoiceApiService().endpointCreate(client().getAuthId(), this);
  }

  @Override
  protected Call<EndpointCreateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().endpointCreate(client().getAuthId(), this);
  }

  @Override
  protected Call<EndpointCreateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().endpointCreate(client().getAuthId(), this);
  }
}