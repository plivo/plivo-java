package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.node.NodeMultiPartyCall;
import com.plivo.api.models.phlo.Phlo;
import org.junit.Before;
import org.junit.Test;

public class NodeMultiPartyCallMemberTest extends BaseTest {
  private Phlo phlo;
  private NodeMultiPartyCall nodeMultiPartyCall;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);
    expectResponse("multiPartyCallActionResponse.json", 200);

    phlo = Phlo
      .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
      .get();

    nodeMultiPartyCall = phlo.multiPartyCallGetter(
      "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();
  }

  @Test
  public void abortTransferShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberAbortWarmTransferCreator("11111111111").abortwarmtransfer();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void abortTransferVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberAbortWarmTransferCreator("11111111111").abortwarmtransfer();

    JsonNode payload = actualRequestPayload();
    assertEquals("abort_transfer", payload.get("action").asText());
  }

  @Test
  public void abortTransferWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberAbortWarmTransferCreator("11111111111").client(client).abortwarmtransfer();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberResumeCallCreator("11111111111").resumecall();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberResumeCallCreator("11111111111").resumecall();

    JsonNode payload = actualRequestPayload();
    assertEquals("resume_call", payload.get("action").asText());
  }

  @Test
  public void resumeCallWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberResumeCallCreator("11111111111")
      .client(client).resumecall();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberVoiceMailDropCreator("11111111111").voicemaildrop();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberVoiceMailDropCreator("11111111111").voicemaildrop();

    JsonNode payload = actualRequestPayload();
    assertEquals("voicemail_drop", payload.get("action").asText());
  }

  @Test
  public void voiceMailDropWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberVoiceMailDropCreator("11111111111")
      .client(client).voicemaildrop();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHangUpCreator("11111111111").hangup();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHangUpCreator("11111111111").hangup();

    JsonNode payload = actualRequestPayload();
    assertEquals("hangup", payload.get("action").asText());
  }

  @Test
  public void hangupWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHangUpCreator("11111111111").client(client)
      .hangup();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHoldCreator("11111111111").hold();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHoldCreator("11111111111").hold();

    JsonNode payload = actualRequestPayload();
    assertEquals("hold", payload.get("action").asText());
  }

  @Test
  public void holdWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberHoldCreator("11111111111").client(client).hold();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberUnHoldCreator("11111111111").unhold();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberUnHoldCreator("11111111111").unhold();

    JsonNode payload = actualRequestPayload();
    assertEquals("unhold", payload.get("action").asText());
  }

  @Test
  public void unholdWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    nodeMultiPartyCall.memberUnHoldCreator("11111111111").client(client).unhold();


    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

}
