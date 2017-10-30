package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.BaseResponse;

public class EndpointCreateResponse extends BaseResponse {

  private String username;
  private String alias;
  private String endpointId;

  public String getUsername() {
    return username;
  }

  public String getAlias() {
    return alias;
  }

  public String getEndpointId() {
    return endpointId;
  }
}
