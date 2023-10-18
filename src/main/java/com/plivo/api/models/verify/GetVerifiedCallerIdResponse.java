package com.plivo.api.models.verify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

@JsonIgnoreProperties("id")
public class GetVerifiedCallerIdResponse extends BaseResource {

  private String alias;
  private String apiId;
  private String country;
  private String createdAt;
  private String modifiedAt;
  private String phoneNumber;
  private String subaccount;
  private String verificationUuid;

  public String getAlias() {
    return alias;
  }

  public String getCountry() {
    return country;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getModifiedAt() {
    return modifiedAt;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getSubaccount() {
    return subaccount;
  }

  public String getVerificationUuid() {
    return verificationUuid;
  }

  @Override
  public String getApiId() {
    return apiId;
  }

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }
}
