package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class EndpointCreator extends Creator<EndpointCreateResponse> {

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
    return client().getApiService().endpointCreate(client().getAuthId(), this);
  }
}
