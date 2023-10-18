package com.plivo.api.models.verify;

import com.plivo.api.models.base.BaseResponse;

public class VerifyCallerIdResponse extends BaseResponse {

  private String alias;
  private String apiId;
  private String channel;
  private String country;
  private String createdAt;
  private String phoneNumber;
  private String verificationUuid;
  private String subaccount;

  public String getAlias() {
    return alias;
  }

  public String getChannel() {
    return channel;
  }

  public String getCountry() {
    return country;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getVerificationUuid() {
    return verificationUuid;
  }

  public String getSubaccount() {
    return subaccount;
  }
}
