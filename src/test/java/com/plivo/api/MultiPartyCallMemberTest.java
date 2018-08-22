package com.plivo.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.phlo.Phlo;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MultiPartyCallMemberTest extends BaseTest {
  private Phlo phlo;
  private MultiPartyCall multiPartyCall;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);
    expectResponse("multiPartyCallActionResponse.json", 200);

    phlo = Phlo
      .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
      .get();

    multiPartyCall = phlo.multiPartyCallGetter(
      "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();
  }

  @Test
  public void abortTransferShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").abortWarmTransfer().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void abortTransferVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").abortWarmTransfer().create();

    JsonNode payload = actualRequestPayload();
    assertEquals("abortwarmtransfer", payload.get("action").asText());
  }

  @Test
  public void abortTransferWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").abortWarmTransfer()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").resumeCall().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").resumeCall().create();

    JsonNode payload = actualRequestPayload();
    assertEquals("resumecall", payload.get("action").asText());
  }

  @Test
  public void resumeCallWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").resumeCall()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").voiceMailDrop().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").voiceMailDrop().create();

    JsonNode payload = actualRequestPayload();
    assertEquals("voicemaildrop", payload.get("action").asText());
  }

  @Test
  public void voiceMailDropWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
         "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").voiceMailDrop()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").hangup().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").hangup().create();

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

    multiPartyCall.member("11111111111").hangup()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").hold().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").hold().create();

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

    multiPartyCall.member("11111111111").hold()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").unhold().create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.member("11111111111").unhold().create();

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

    multiPartyCall.member("11111111111").unhold()
      .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

}
