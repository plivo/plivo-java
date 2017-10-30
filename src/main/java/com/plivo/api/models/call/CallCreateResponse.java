package com.plivo.api.models.call;

import com.plivo.api.models.base.BaseResponse;

public class CallCreateResponse extends BaseResponse {

  private String requestUuid;

  public String getRequestUuid() {
    return requestUuid;
  }
}
