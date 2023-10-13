package com.plivo.api.models.verify;

import com.plivo.api.models.base.BaseResponse;

public class InitiateVerifyResponse extends BaseResponse {
  private String apiId;

  private String message;

  private String verificationUuid;

  public String getVerificationUuid() {
    return verificationUuid;
  }
}
