package com.plivo.api.models.address;

import com.plivo.api.models.base.BaseResponse;

public class AddressCreateResponse extends BaseResponse {
  private String appId;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }
}
