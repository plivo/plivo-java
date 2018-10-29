package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.MultiPartyCallUpdateResponse;
import com.plivo.api.models.phlo.Phlo;
import org.junit.Before;
import org.junit.Test;

public class MultiPartyCallTest extends BaseTest {

  private Phlo phlo;
  private PlivoClient client;

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
  }

  @Test
  public void multiPartyCallNodeCallActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").call().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiPartyCallNodeCallActionVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();


    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").call().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("1111111111", payload.get("trigger_source").asText());
    assertEquals("agent", payload.get("role").asText());
  }


  @Test
  public void multiPartyCallNodeCallActionWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").call().client(client).update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiPartyCallNodeWarmTransferActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").warm_transfer().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiPartyCallNodeWarmTransferActionVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").warm_transfer().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("1111111111", payload.get("trigger_source").asText());
    assertEquals("warm_transfer", payload.get("action").asText());
  }

  @Test
  public void multiPartyCallNodeWarmTransferActionWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").warm_transfer().client(client).update();


    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiPartyCallNodeColdTransferActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").cold_transfer().update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiPartyCallNodeColdTransferActionVerifyRequestBody() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").cold_transfer().update();

    JsonNode payload = actualRequestPayload();
    assertEquals("1111111111", payload.get("trigger_source").asText());
    assertEquals("cold_transfer", payload.get("action").asText());
  }

  @Test
  public void multiPartyCallNodeColdTransferActionWithClientShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = MultiPartyCall.getter(phloId, nodeId).get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    MultiPartyCallUpdateResponse response = MultiPartyCall.updater(phloId, nodeId).triggerSource("1111111111").to("1111111111").role("agent").cold_transfer().client(client).update();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
         "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

}