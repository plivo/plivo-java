package com.plivo.api;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.message.Message;
import com.plivo.api.models.message.MessageDirection;
import com.plivo.api.models.message.MessageState;
import com.plivo.api.models.verify_session.VerifySession;
import com.plivo.api.models.verify_session.VerifySessionList;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class VerifySessionTest extends BaseTest{
  private PlivoClient client;
  List<String> list = null;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidSessionCreated() throws Exception {
    expectResponse("createSession.json", 202);

    VerifySession.creator(null,null, null, null, null,null, null, null, 0, null, null)
      .create();
  }

  @Test
  public void sessionCreated() throws Exception {
    expectResponse("createSession.json", 202);

    VerifySession.creator(null,"+1234567890", null, null, null, null, null, null, 0, null, null)
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void invalidValidation() throws Exception {
    expectResponse("createSession.json", 202);

    VerifySession.validation(null,null)
      .create();
  }

  @Test
  public void successValidation() throws Exception {
    expectResponse("createSession.json", 202);

    VerifySession.validation("1234567890","123456")
      .create();
  }

  @Test
  public void getSession() throws Exception {
    expectResponse("getSession.json", 200);

    VerifySession session = VerifySession.getter("78ae7ada-b87c-449c-86b7-91443da3a68b").get();

    assertEquals("78ae7ada-b87c-449c-86b7-91443da3a68b", session.getSessionUuid());
  }

  @Test
  public void listSession() throws Exception {
    expectResponse("listSession.json", 202);

    ListResponse<VerifySessionList> response = VerifySession.lister()
      .list();
    assertEquals("10.0.23.253", response.getSessions().get(0).getRequestorIP());

  }

  @Test
  public void getSessionShouldExposeInrChargesForInrAccount() throws Exception {
    expectResponse("getSessionInr.json", 200);

    VerifySession session = VerifySession.getter("78ae7ada-b87c-449c-86b7-91443da3a68b").get();

    assertEquals("0.00600", session.getCharges().getTotalCharge());
    assertEquals("0.52800", session.getCharges().getTotalChargeInr());
    assertEquals("0.52800", session.getCharges().getAttemptCharges().get(0).getChargeInr());
    assertEquals(Double.valueOf(0.006), session.getAttemptDetails().get(0).getAmount());
    assertEquals(Double.valueOf(0.528), session.getAttemptDetails().get(0).getAmountInr());
  }

  @Test
  public void getSessionShouldLeaveInrChargesNullForUsdAccount() throws Exception {
    expectResponse("getSession.json", 200);

    VerifySession session = VerifySession.getter("78ae7ada-b87c-449c-86b7-91443da3a68b").get();

    assertNull(session.getCharges().getTotalChargeInr());
    assertNull(session.getCharges().getAttemptCharges().get(0).getChargeInr());
    assertNull(session.getAttemptDetails().get(0).getAmountInr());
  }

  @Test
  public void listSessionShouldExposeInrCharges() throws Exception {
    expectResponse("listSession.json", 200);

    ListResponse<VerifySessionList> response = VerifySession.lister().list();

    VerifySessionList session = response.getSessions().get(0);
    assertEquals("0.52800", session.getCharges().getTotalChargeInr());
    assertEquals("0.52800", session.getCharges().getAttemptCharges().get(0).getChargeInr());
    assertEquals(Double.valueOf(0.006), session.getAttemptDetails().get(0).getAmount());
    assertEquals(Double.valueOf(0.528), session.getAttemptDetails().get(0).getAmountInr());
  }
}
