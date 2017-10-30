package com.plivo.api.models.application;

import com.plivo.api.models.base.BaseResponse;

public class ApplicationCreateResponse extends BaseResponse {

  private String appId;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }
}
