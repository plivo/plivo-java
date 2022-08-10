package com.plivo.api.models.token;

import com.plivo.api.models.base.BaseResponse;

public class TokenCreateResponse extends BaseResponse {
  private String api_id;
  private String token;
  public String getApi_id() {
    return api_id;
  }

  public String getToken() {
    return token;
  }

}
