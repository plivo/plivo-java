package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.BaseResponse;

public class TollfreeVerificationCreateResponse extends BaseResponse {
  private String uuid;

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
