package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResponse;

public class MultiPartyCallUpdateResponse extends NodeUpdateResponse {
  private String error;

  public String getError() {
    return error;
  }
}
