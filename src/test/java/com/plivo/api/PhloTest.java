package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.Node;
import com.plivo.api.models.node.NodeType;
import com.plivo.api.models.phlo.Phlo;
import com.plivo.api.models.phlo.PhloRunResponse;
import org.junit.Test;

public class PhloTest extends BaseTest {

  @Test
  public void phloGetShouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);

    Phlo phlo = Phlo
        .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .get();

    assertEquals("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6", phlo.getId());
    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");
  }

  @Test
  public void phloGetWithClientShouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);

    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Phlo phlo = Phlo
        .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .client(client)
        .get();

    assertEquals("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6", phlo.getId());
    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");
  }

  @Test
  public void nodeGetShouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);

    Phlo phlo = Phlo
          .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
          .get();

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    Node node = phlo.nodeGetter(NodeType.MULTIPARTYCALL,
          "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertEquals("f4789ccf-25f5-4a1f-91a4-55ca022ba903", node.getNodeId());

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void nodeGetSWithClienthouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Phlo phlo = Phlo
          .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
          .get();

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    Node node = phlo.nodeGetter(NodeType.MULTIPARTYCALL,
          "f4789ccf-25f5-4a1f-91a4-55ca022ba903").client(client).get();

    assertEquals("f4789ccf-25f5-4a1f-91a4-55ca022ba903", node.getNodeId());

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
          "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiParyCallGetShouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);

    Phlo phlo = Phlo
        .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .get();

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertEquals("f4789ccf-25f5-4a1f-91a4-55ca022ba903", multiPartyCall.getNodeId());

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void multiParyCallWithClientGetShouldSucceed() throws Exception {
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);

    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Phlo phlo = Phlo
        .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .client(client).get();

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").client(client).get();

    assertEquals("f4789ccf-25f5-4a1f-91a4-55ca022ba903", multiPartyCall.getNodeId());

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");
  }

  @Test
  public void phloRunnerShouldSucceed() throws Exception {
    expectResponse("phloRunnerResponse.json", 200);

    PhloRunResponse phloRunResponse = Phlo
        .runner("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .create();

    assertApiRequest("POST", "/account/MA123456789012345678/",
        "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");
  }

  @Test
  public void phloRunnerWithClientShouldSucceed() throws Exception {
    expectResponse("phloRunnerResponse.json", 200);
    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    PhloRunResponse phloRunResponse = Phlo
        .runner("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .client(client)
        .create();

    assertApiRequest("POST", "/account/MA123456789012345678/",
        "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");
  }

}
