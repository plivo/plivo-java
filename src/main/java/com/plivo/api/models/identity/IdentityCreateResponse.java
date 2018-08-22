package com.plivo.api.models.identity;

import com.plivo.api.models.base.BaseResponse;

public class IdentityCreateResponse  extends BaseResponse {
  private String appId;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }
}
