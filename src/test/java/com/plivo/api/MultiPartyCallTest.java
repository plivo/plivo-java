package com.plivo.api;

import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.phlo.Phlo;
import org.junit.Before;
import org.junit.Test;

public class MultiPartyCallTest extends BaseTest {

  private Phlo phlo;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    expectResponse("phloGetResponse.json", 200);
    expectResponse("multiPartyCallGetResponse.json", 200);
    expectResponse("multiPartyCallActionResponse.json", 200);

    phlo = Phlo
        .getter("a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6")
        .get();
  }

  @Test
  public void multiPartyCallNodeCallActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.call("1111111111", "1111111111", "agent").create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"call\"}");
  }

  @Test
  public void multiPartyCallNodeCallActionWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.call("1111111111", "1111111111", "agent")
        .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"call\"}");
  }

  @Test
  public void multiPartyCallNodeWarmTransferActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.warmTransfer("1111111111", "1111111111", "agent").create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"warmtransfer\"}");
  }

  @Test
  public void multiPartyCallNodeWarmTransferActionWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.warmTransfer("1111111111", "1111111111", "agent")
        .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"warmtransfer\"}");
  }

  @Test
  public void multiPartyCallNodeColdTransferActionShouldSucceed() throws Exception {

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.coldTransfer("1111111111", "1111111111", "agent").create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"coldtransfer\"}");
  }

  @Test
  public void multiPartyCallNodeColdTransferActionWithClientShouldSucceed() throws Exception {

    PlivoClient client = new PlivoClient("MA123456789012345678",
        "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    assertApiRequest("GET", "/", "phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6");

    MultiPartyCall multiPartyCall = phlo.multiPartyCallGetter(
        "f4789ccf-25f5-4a1f-91a4-55ca022ba903").get();

    assertApiRequest("GET", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903");

    multiPartyCall.coldTransfer("1111111111", "1111111111", "agent")
        .client(client).create();

    assertApiRequest("POST", "/phlo/a9f74ec4-2d3f-41d6-b8f0-f341fcfb59b6/",
        "multi_party_call/f4789ccf-25f5-4a1f-91a4-55ca022ba903",
        "{\"trigger_source\":\"1111111111\",\"to\":\"1111111111\",\"role\":\"agent\",\"action\":\"coldtransfer\"}");
  }

}