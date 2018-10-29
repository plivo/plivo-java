package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.MultiPartyCallUpdateResponse;
import com.plivo.api.models.phlo.Phlo;
import org.junit.Before;
import org.junit.Test;

public class MultiPartyCallMemberTest extends BaseTest {
  private Phlo phlo;
  PlivoClient client;
  private String phloId = "a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6";
  private String nodeId = "f4789ccf-25f5-4a1f-91a4-55ca022ba903";

  @Before
  public void setUp() throws Exception {
    super.setUp();
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);
    expectResponse("multiPartyCallActionResponse.json", 200);
    client = new PhloRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    phlo = Phlo
      .getter(phloId)
      .get();

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

  }

  @Test
  public void abortTransferShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").abort_transfer().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void abortTransferVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").abort_warm_transfer().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("abort_transfer", payload.get("action").asText());
  }

  @Test
  public void abortTransferWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").abort_warm_transfer().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").resume_call().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void resumeCallVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").resume_call().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("resume_call", payload.get("action").asText());
  }

  @Test
  public void resumeCallWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").resume_call().client(client).update();


    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").voicemail_drop().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void voiceMailDropVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").voicemail_drop().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("voicemail_drop", payload.get("action").asText());
  }

  @Test
  public void voiceMailDropWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").voicemail_drop().client(client).update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hangup().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void hangupVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hangup().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("hangup", payload.get("action").asText());
  }

  @Test
  public void hangupWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hangup().client(client).update();


    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hold().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void holdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hold().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("hold", payload.get("action").asText());
  }

  @Test
  public void holdWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").hold().client(client).update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").unhold().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

  @Test
  public void unholdVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").unhold().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("unhold", payload.get("action").asText());
  }

  @Test
  public void unholdWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).member("11111111111").unhold().client(client).update();


    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903/members/11111111111");
  }

}
