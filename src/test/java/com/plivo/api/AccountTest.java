package com.plivo.api;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.plivo.api.models.account.Account;
import com.plivo.api.models.account.Subaccount;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Test;

public class AccountTest extends BaseTest {

  @Test
  public void accountGetShouldSucceed() throws Exception {
    String response = expectResponse("accountGetResponse.json", 200);

    Account account = Account.getter()
      .get();

    assertEquals(account.getId(), account.getAuthId());

    assertRequest("GET", "");
  }

  @Test
  public void accountGetWithClientShouldSucceed() throws Exception {
    String response = expectResponse("accountGetResponse.json", 200);
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Account account = Account.getter().client(client)
      .get();
    assertEquals(account.getId(), account.getAuthId());

    assertRequest("GET", "");
  }

  @Test
  public void accountModifyShouldSucceed() throws Exception {
    String fixtureName = "accountModifyResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(loadFixture(fixtureName))
    );

    Account.updater()
      .address("test")
      .name("test")
      .city("test")
      .update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/", authId),
      recordedRequest.getPath());
  }

  @Test
  public void accountModifyWithClientShouldSucceed() throws Exception {
    String fixtureName = "accountModifyResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(loadFixture(fixtureName))
    );
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Account.updater()
      .address("test")
      .name("test")
      .city("test")
      .client(client).update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/", authId),
      recordedRequest.getPath());
  }

//  @Test(expected = IllegalStateException.class)
//  public void accountModifyShouldFailWithNoChanges() throws Exception {
//    Account account = new Account();
//    account.updater()
//      .update();
//  }

  @Test
  public void subaccountCreateShouldSucceed() throws Exception {

    expectResponse("subaccountCreateResponse.json", 200);

    Subaccount.creator("Test")
      .enabled(true)
      .create();

    assertRequest("POST", "Subaccount/");
  }

  @Test
  public void subaccountCreateWithClientShouldSucceed() throws Exception {

    expectResponse("subaccountCreateResponse.json", 200);
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Subaccount.creator("Test")
      .enabled(true)
      .client(client).create();

    assertRequest("POST", "Subaccount/");
  }

  @Test
  public void subaccountGetShouldSucceed() throws Exception {
    String fixtureName = "subaccountGetResponse.json";
    String subauthId = "SAODNKNDDMY2EXY2JKMG";
    expectResponse(fixtureName, 200);

    Subaccount subaccount = Subaccount.getter(subauthId).get();

    assertEquals(subaccount.getId(), subaccount.getAuthId());

    assertRequest("GET", "Subaccount/%s/", subauthId);
    assertEquals(subauthId, subaccount.getAuthId());
  }

  @Test
  public void subaccountGetWithClientShouldSucceed() throws Exception {
    String fixtureName = "subaccountGetResponse.json";
    String subauthId = "SAODNKNDDMY2EXY2JKMG";
    expectResponse(fixtureName, 200);
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
    Subaccount subaccount = Subaccount.getter(subauthId).client(client).get();

    assertEquals(subaccount.getId(), subaccount.getAuthId());

    assertRequest("GET", "Subaccount/%s/", subauthId);
    assertEquals(subauthId, subaccount.getAuthId());
  }

  @Test
  public void subaccountListShouldSucceed() throws Exception {
    String fixtureName = "subaccountListResponse.json";

    expectResponse(fixtureName, 200);

    Subaccount.lister()
      .list();

    assertRequest("GET", "Subaccount/");
  }

  @Test
  public void subaccountListWithClientShouldSucceed() throws Exception {
    String fixtureName = "subaccountListResponse.json";

    expectResponse(fixtureName, 200);
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    Subaccount.lister().client(client)
      .list();

    assertRequest("GET", "Subaccount/");
  }

  @Test
  public void subaccountModifyShouldSucceed() throws Exception {
    String fixtureName = "subaccountModifyResponse.json";
    String subauthId = "SAMTVIYJDIYWYYMZHLYZ";

    expectResponse(fixtureName, 202);

    Subaccount.updater(subauthId, "name")
      .enabled(true)
      .update();

    assertRequest("POST", "Subaccount/%s/", subauthId);
  }

  @Test
  public void subaccountModifyWithClientShouldSucceed() throws Exception {
    String fixtureName = "subaccountModifyResponse.json";
    String subauthId = "SAMTVIYJDIYWYYMZHLYZ";
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    expectResponse(fixtureName, 202);

    Subaccount.updater(subauthId, "name")
      .enabled(true)
      .client(client)
      .update();

    assertRequest("POST", "Subaccount/%s/", subauthId);
  }

  @Test
  public void subaccountDeleteShouldSucceed() throws Exception {
    expectResponse(null, 204);

    String subauthId = "SAMTVIYJDIYWYYMZHLYZ";

    Subaccount.deleter(subauthId).delete();

    assertRequest("DELETE", "Subaccount/%s/", subauthId);
  }

  @Test
  public void subaccountDeleteWithClientShouldSucceed() throws Exception {
    expectResponse(null, 204);
    PlivoClient client = new PlivoRestClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();

    String subauthId = "SAMTVIYJDIYWYYMZHLYZ";

    Subaccount.deleter(subauthId).client(client).delete();

    assertRequest("DELETE", "Subaccount/%s/", subauthId);
  }
}
