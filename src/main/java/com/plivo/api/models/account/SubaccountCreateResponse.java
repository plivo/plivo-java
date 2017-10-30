package com.plivo.api.models.account;

import com.plivo.api.models.base.BaseResponse;

public class SubaccountCreateResponse extends BaseResponse {

  private String authId;
  private String authToken;

  public String getAuthId() {
    return authId;
  }

  public void setAuthId(String authId) {
    this.authId = authId;
  }

  public String getAuthToken() {
    return authToken;
  }

  public void setAuthToken(String authToken) {
    this.authToken = authToken;
  }
}
