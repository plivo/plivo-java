package com.plivo.api.models.verify;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResource;

public class Verify extends BaseResource {

  public static InitiateVerify initiateVerify() {
    return new InitiateVerify();
  }

  public static VerifyCallerId verifyCallerId(String verificationUuid) {
    return new VerifyCallerId(verificationUuid);
  }

  public static UpdateVerifiedCallerID updateVerifiedCallerID(String phoneNumber) {
    return new UpdateVerifiedCallerID(phoneNumber);
  }

  public static GetVerifiedCallerId getVerifiedCallerID(String phoneNumber) {
    return new GetVerifiedCallerId(phoneNumber);
  }

  public static ListVerifiedCallerId listVerifiedCallerID() {
    return new ListVerifiedCallerId();
  }

  public static VerifiedCallerIdDeleter deleteVerifiedCallerID(String phoneNumber) {
    return new VerifiedCallerIdDeleter(phoneNumber);
  }

  @Override
  public String getId() throws PlivoValidationException {
    return null;
  }
}
