package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

import java.util.Date;

public class GetVerifiedCallerIdResponse extends BaseResource {

  private String alias;
  private String apiId;
  private String country;
  private Date createdAt;
  private Date modifiedAt;
  private String phoneNumber;
  private String subaccount;
  private String verificationUuid;

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }
}
