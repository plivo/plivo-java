package com.plivo.api;

import com.plivo.api.models.verify.Verify;
import org.junit.Before;
import org.junit.Test;

public class VerifyTest extends BaseTest{

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void initiateVerifyShouldWork() throws Exception {
    expectResponse("initiateVerifyResponse.json", 200);

    Verify.initiateVerify().phoneNumber("91999999999").create();

    assertRequest("POST", "VerifiedCallerId/");
  }

  @Test
  public void verifyCallerIdShouldWork() throws Exception {
    expectResponse("verifyCallerIdResponse.json", 200);
    final String verificationUuid = "verificationUuid";
    Verify.verifyCallerId(verificationUuid).otp("otp").create();

    assertRequest("POST", "VerifiedCallerId/Verification/%s/",verificationUuid);
  }

  @Test
  public void updateVerifiedCallerIdShouldWork() throws Exception {
    expectResponse("updateVerifiedCallerIdResponse.json", 200);
    final String phoneNumber = "phoneNumber";
    Verify.updateVerifiedCallerID(phoneNumber).alias("test").update();

    assertRequest("POST", "VerifiedCallerId/%s",phoneNumber);
  }

  @Test
  public void getVerifiedCallerIdShouldWork() throws Exception {
    expectResponse("updateVerifiedCallerIdResponse.json", 200);
    final String phoneNumber = "phoneNumber";
    Verify.getVerifiedCallerID(phoneNumber).get();

    assertRequest("GET", "VerifiedCallerId/%s",phoneNumber);
  }

  @Test
  public void listVerifiedCallerIdShouldWork() throws Exception {
    expectResponse("listVerifiedCallerIdResponse.json", 200);

    Verify.listVerifiedCallerID().country("IN").get();

    assertRequest("GET", "VerifiedCallerId/");
  }

  @Test
  public void deleteVerifiedCallerIdShouldWork() throws Exception {
    expectResponse("deleteVerifiedCallerIdResponse.json", 204);

    final String phoneNumber = "phoneNumber";
    Verify.deleteVerifiedCallerID(phoneNumber).delete();

    assertRequest("DELETE", "VerifiedCallerId/%s",phoneNumber);
  }


}
