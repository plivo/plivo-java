package com.plivo.api;

import com.plivo.api.models.identity.Identity;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

public class IdentityTest extends BaseTest {
  @Test
  public void identityCreateShouldSucceed() throws Exception {
    expectResponse("identityCreateResponse.json", 201);

    Identity
      .creator("FR",
        "MR",
        "Bruce",
        "Wayne",
        "Rome",
         LocalDate.of(1980, Month.FEBRUARY, 4),
        "FR",
        "100",
         LocalDate.of(1996, Month.JANUARY, 4),
        "plivo",
        "passport",
        "33522",
        "128",
        "RUE DU COMMANDANT GUILBAUD",
        "PARIS",
        "PARIS",
        "75016")
      .create();

    assertRequest("POST", "Verification/Identity/");
  }

  @Test
  public void identityCreateWithClientShouldSucceed() throws Exception {
    expectResponse("identityCreateResponse.json", 201);

    PlivoClient client = new PlivoClient("MA123456789012345678",
                                "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Identity
      .creator("FR",
        "MR",
        "Bruce",
        "Wayne",
        "Rome",
         LocalDate.of(1980, Month.FEBRUARY, 4),
        "FR",
        "100",
         LocalDate.of(1996, Month.JANUARY, 4),
        "plivo",
        "passport",
        "33522",
        "128",
        "RUE DU COMMANDANT GUILBAUD",
        "PARIS",
        "PARIS",
        "75016")
      .client(client)
      .create();

    assertRequest("POST", "Verification/Identity/");
  }

  @Test
  public void identityGetShouldSucceed() throws Exception {
    String id = "24856289978366";
    expectResponse("identityGetResponse.json", 200);

    Identity.getter(id).get();
    assertRequest("GET", "Verification/Identity/%s/", id);
  }

  @Test
  public void identityGetWithClientShouldSucceed() throws Exception {
    String id = "24856289978366";
    expectResponse("identityGetResponse.json", 200);
    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Identity.getter(id).client(client).get();
    assertRequest("GET", "Verification/Identity/%s/", id);
  }

  @Test
  public void identityListShouldSucceed() throws Exception {
    String fixtureName = "identityListResponse.json";
    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Identity.lister().list();
    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/", authId),
          recordedRequest.getPath());
  }

  @Test
  public void identityListWithClientShouldSucceed() throws Exception {
    String fixtureName = "identityListResponse.json";
    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Identity.lister().client(client).list();
    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/", authId),
          recordedRequest.getPath());
  }

  @Test
  public void identityModifyShouldSucceed() throws Exception {
    String fixtureName = "identityModifyResponse.json";
    String identityId = "24856289978366";

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    Identity.updater(identityId).update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/%s/", authId, identityId),
          recordedRequest.getPath());
  }

  @Test
  public void identityModifyWithClientShouldSucceed() throws Exception {
    String fixtureName = "identityModifyResponse.json";
    String identityId = "24856289978366";

    server.enqueue(new MockResponse()
          .setResponseCode(200)
          .setBody(loadFixture(fixtureName))
    );

    PlivoClient client = new PlivoClient("MA123456789012345678",
            "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Identity.updater(identityId).client(client).update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/%s/", authId, identityId),
          recordedRequest.getPath());
  }

  @Test
  public void identityDeleteShouldSucceed() throws Exception {
    String identityId = "24856289978366";

    server.enqueue(new MockResponse()
          .setResponseCode(204)
    );

    Identity.deleter(identityId)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/%s/", authId, identityId),
          recordedRequest.getPath());
  }

  @Test
  public void identityDeleteWithClientShouldSucceed() throws Exception {
    String identityId = "24856289978366";

    server.enqueue(new MockResponse()
          .setResponseCode(204)
    );

    PlivoClient client = new PlivoClient("MA123456789012345678",
          "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Identity.deleter(identityId).client(client)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Verification/Identity/%s/", authId, identityId),
          recordedRequest.getPath());
  }
}
