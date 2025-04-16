package com.plivo.api;

import com.plivo.api.models.tollfree_verification.TollfreeVerification;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

public class TollfreeVerificationTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void tollfreeVerificationCreateShouldSucceed() throws Exception {
    expectResponse("tollfreeVerificationCreateResponse.json", 201);

    TollfreeVerification.creator()
      .profileUuid("fb239ee1-fb5c-4dd9-b55c-5cf10170e756")
      .number("18557312530")
      .usecase("FRAUD_ALERT")
      .usecaseSummary("summary")
      .optinImageUrl("https://wwww.optinurl.com")
      .optinType("VERBAL")
      .messageSample("message sample")
      .volume("10")
      .additionalInformation("additional information")
      .extraData("extra data")
      .callbackMethod("POST")
      .callbackMethod("https://www.callbackurl.com")
      .create();

    assertRequest("POST", "TollfreeVerification/");
  }

  @Test
  public void tollfreeVerificationCreateWithAllParamsShouldSucceed() throws Exception {
    expectResponse("tollfreeVerificationCreateResponse.json", 201);

    TollfreeVerification.creator("fb239ee1-fb5c-4dd9-b55c-5cf10170e756","18557312530","FRAUD_ALERT",
        "usecase summary","htts://optimimageurl.com","message sample","VERBAL",
        "10","additional information","extra data","https://callbackurl.com","POST"
      ).create();

    assertRequest("POST", "TollfreeVerification/");
  }

  @Test
  public void tollfreeVerificationCreateWithMandatoryParamsShouldSucceed() throws Exception {
    expectResponse("tollfreeVerificationCreateResponse.json", 201);

    TollfreeVerification.creator("fb239ee1-fb5c-4dd9-b55c-5cf10170e756","18557312530","FRAUD_ALERT",
      "usecase summary","htts://optimimageurl.com","message sample","VERBAL",
      "10","additional information"
    ).create();

    assertRequest("POST", "TollfreeVerification/");
  }
  @Test
  public void tollfreeVerificationGetShouldSucceed() throws Exception {
    String uuid = "uuid";
    expectResponse("tollfreeVerificationGetResponse.json", 200);

    TollfreeVerification tollfreeVerification = TollfreeVerification.getter(uuid)
      .get();

    assertEquals(tollfreeVerification.getId(), tollfreeVerification.getUuid());

    assertRequest("GET", "TollfreeVerification/%s/", uuid);
  }

  @Test
  public void tollfreeVerificationListShouldSucceed() throws Exception {
    String fixtureName = "tollfreeVerificationListResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    TollfreeVerification.lister()
      .list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/TollfreeVerification/", authId), recordedRequest.getPath());
  }

  @Test
  public void tollfreeVerificationUpdateShouldSucceed() throws Exception {
    String fixtureName = "tollfreeVerificationUpdateResponse.json";
    String uuid = "uuid";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    TollfreeVerification.updater(uuid)
      .update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/TollfreeVerification/%s/", authId, uuid),
      recordedRequest.getPath());
  }

  @Test
  public void tollfreeVerificationDeleteShouldSucceed() throws Exception {
    String uuid = "uuid";

    server.enqueue(new MockResponse()
      .setResponseCode(204)
    );

    TollfreeVerification.deleter(uuid)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/TollfreeVerification/%s/", authId, uuid),
      recordedRequest.getPath());
  }

}
