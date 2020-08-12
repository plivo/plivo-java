package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class EndpointUpdater extends VoiceUpdater<EndpointUpdateResponse> {

  private String password;
  private String alias;
  private String appId;

  public EndpointUpdater(String id) {
    super(id);
  }

  public String password() {
    return this.password;
  }

  public String alias() {
    return this.alias;
  }

  public String appId() {
    return this.appId;
  }

  public EndpointUpdater password(final String password) {
    this.password = password;
    return this;
  }

  public EndpointUpdater alias(final String alias) {
    this.alias = alias;
    return this;
  }

  public EndpointUpdater appId(final String appId) {
    this.appId = appId;
    return this;
  }

  @Override
  protected Call<EndpointUpdateResponse> obtainCall() {
    return client().getVoiceApiService().endpointUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<EndpointUpdateResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().endpointUpdate(client().getAuthId(), id, this);
  }

  @Override
  protected Call<EndpointUpdateResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().endpointUpdate(client().getAuthId(), id, this);
  }
}
