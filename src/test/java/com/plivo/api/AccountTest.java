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
  public void subaccountListShouldSucceed() throws Exception {
    String fixtureName = "subaccountListResponse.json";

    expectResponse(fixtureName, 200);

    Subaccount.lister()
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
  public void subaccountDeleteShouldSucceed() throws Exception {
    expectResponse(null, 204);

    String subauthId = "SAMTVIYJDIYWYYMZHLYZ";

    Subaccount.deleter(subauthId).delete();

    assertRequest("DELETE", "Subaccount/%s/", subauthId);
  }
}
