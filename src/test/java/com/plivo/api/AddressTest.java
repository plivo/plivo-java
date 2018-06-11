package com.plivo.api;

import com.plivo.api.models.address.Address;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Test;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

public class AddressTest extends BaseTest {
  @Test
  public void addressCreateShouldSucceed() throws Exception {
    expectResponse("addressCreateResponse.json", 201);

    Address.creator("FR",
      "Mr",
      "Bruce",
      "Wayne",
      "128",
      "RUE DU COMMANDANT GUILBAUD",
      "PARIS",
      "PARIS",
      "75016")
      .create();

    assertRequest("POST", "Verification/Address/");
  }

  @Test
  public void addressCreateWithClientShouldSucceed() throws Exception {
    expectResponse("addressCreateResponse.json", 201);
    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Address.creator("FR",
      "Ms",
      "Bruce",
      "Wayne",
      "128",
      "RUE DU COMMANDANT GUILBAUD",
      "PARIS",
      "PARIS",
      "75016")
      .client(client)
      .create();

    assertRequest("POST", "Verification/Address/");
  }

  @Test
  public void addressGetShouldSucceed() throws Exception {
    expectResponse("addressGetResponse.json", 200);
    String addressId = "myaddress";

    Address.getter(addressId).get();

    assertRequest("GET", "Verification/Address/%s/", addressId);
  }

  @Test
  public void addressGetWithClientShouldSucceed() throws Exception {
    expectResponse("addressGetResponse.json", 200);
    String addressId = "myaddress";
    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Address.getter(addressId).client(client).get();

    assertRequest("GET", "Verification/Address/%s/", addressId);
  }

  @Test
  public void addressListShouldSucceed() throws Exception {
    String fixtureName  = "addressListResponse.json";

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Address.lister().list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/", authId ),
          recordedRequest.getPath());
  }

  @Test
  public void addressListWithClientShouldSucceed() throws Exception {
    String fixtureName  = "addressListResponse.json";
    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Address.lister().client(client).list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/", authId ),
          recordedRequest.getPath());
  }

  @Test
  public void addressModifyShouldSucceed() throws Exception {
    String fixtureName = "addressModifyResponse.json";
    String addressId = "myaddressId";

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Address.updater(addressId).update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/%s/", authId, addressId),
          recordedRequest.getPath());
  }

  @Test
  public void addressModifyWithClientShouldSucceed() throws Exception {
    String fixtureName  = "addressModifyResponse.json";
    String addressId = "myaddressId";

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Address.updater(addressId).client(client).update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/%s/", authId, addressId),
          recordedRequest.getPath());
  }

  @Test
  public void addressDeleteShouldSucceed() throws Exception {
    String addressId = "myaddress";

    server.enqueue(new MockResponse()
          .setResponseCode(204)
    );

    Address.deleter(addressId)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/%s/", authId, addressId),
          recordedRequest.getPath());
  }

  @Test
  public void addressDeleteWithClientShouldSucceed() throws Exception {
    String addressId = "myaddress";
    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    server.enqueue(new MockResponse()
          .setResponseCode(204)
    );

    Address.deleter(addressId).client(client)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Address/%s/", authId, addressId),
          recordedRequest.getPath());
  }
}