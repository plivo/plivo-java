package com.plivo.api;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.application.Application;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

public class ApplicationTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoRestClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx").getClient();
  }

  @Test
  public void applicationCreateShouldSucceed() throws Exception {
    expectResponse("applicationCreateResponse.json", 201);

    Application.creator("My App")
      .answerUrl("http://test.answer.url/")
      .answerMethod("POST")
      .defaultEndpointApp(true)
      .defaultNumberApp(true)
      .fallbackAnswerUrl("http://fa.url")
      .fallbackMethod("POST")
      .messageUrl("http://message.url")
      .messageMethod("POST")
      .create();

    assertRequest("POST", "Application/");
  }

  @Test
  public void applicationCreateWithClientShouldSucceed() throws Exception {
    expectResponse("applicationCreateResponse.json", 201);

    Application.creator("My App")
      .answerUrl("http://test.answer.url/")
      .answerMethod("POST")
      .defaultEndpointApp(true)
      .defaultNumberApp(true)
      .fallbackAnswerUrl("http://fa.url")
      .fallbackMethod("POST")
      .messageUrl("http://message.url")
      .messageMethod("POST")
      .client(client)
      .create();

    assertRequest("POST", "Application/");
  }

  @Test
  public void applicationGetShouldSucceed() throws Exception {
    String appId = "appId";
    expectResponse("applicationGetResponse.json", 200);

    Application application = Application.getter(appId)
      .get();

    assertEquals(application.getId(), application.getAppId());

    assertRequest("GET", "Application/%s/", appId);
  }

  @Test
  public void applicationGetWithClientShouldSucceed() throws Exception {
    String appId = "appId";
    expectResponse("applicationGetResponse.json", 200);

    Application application = Application.getter(appId).client(client)
      .get();

    assertEquals(application.getId(), application.getAppId());

    assertRequest("GET", "Application/%s/", appId);
  }

  @Test
  public void applicationListShouldSucceed() throws Exception {
    String fixtureName = "applicationListResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    Application.lister()
      .list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/", authId), recordedRequest.getPath());
  }

  @Test
  public void applicationListWithClientShouldSucceed() throws Exception {
    String fixtureName = "applicationListResponse.json";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    Application.lister().client(client)
      .list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/", authId), recordedRequest.getPath());
  }

  @Test
  public void applicationModifyShouldSucceed() throws Exception {
    String fixtureName = "applicationModifyResponse.json";
    String appId = "appId";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    Application.updater(appId)
      .update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/%s/", authId, appId),
      recordedRequest.getPath());
  }

  @Test
  public void applicationModifyWithClientShouldSucceed() throws Exception {
    String fixtureName = "applicationModifyResponse.json";
    String appId = "appId";

    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );
    Application.updater(appId).client(client)
      .update();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/%s/", authId, appId),
      recordedRequest.getPath());
  }

//  @Test(expected = IllegalStateException.class)
//  public void applicationModifyShouldFailWithNoChanges() throws Exception {
//    Application application = new Application();
//    application.();
//  }

  @Test
  public void applicationDeleteShouldSucceed() throws Exception {
    String appId = "appId";

    server.enqueue(new MockResponse()
      .setResponseCode(204)
    );

    Application.deleter(appId)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/%s/", authId, appId),
      recordedRequest.getPath());
  }

  @Test
  public void applicationDeleteWithClientShouldSucceed() throws Exception {
    String appId = "appId";

    server.enqueue(new MockResponse()
      .setResponseCode(204)
    );
    Application.deleter(appId).client(client)
      .delete();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("DELETE", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Application/%s/", authId, appId),
      recordedRequest.getPath());
  }
}
