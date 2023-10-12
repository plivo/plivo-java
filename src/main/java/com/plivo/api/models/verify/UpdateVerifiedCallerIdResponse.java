package com.plivo.api.models.verify;

import com.plivo.api.models.base.BaseResponse;

import java.util.Date;

public class UpdateVerifiedCallerIdResponse extends BaseResponse {

  private String alias;
  private String apiId;
  private String country;
  private Date createdAt;
  private Date modifiedAt;
  private String phoneNumber;
  private String subaccount;
  private String verificationUuid;

}
