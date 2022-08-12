package com.plivo.api.models.token;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResponse;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TokenCreateResponse extends BaseResponse {

  private String token;

  public String getToken() {
    return token;
  }

}
