package com.plivo.api;

import com.plivo.api.models.media.Media;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import static com.plivo.api.TestUtil.loadFixture;
import static junit.framework.TestCase.assertEquals;

public class MediaTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void mediaGetShouldSucceed() throws Exception {
    String fixtureName = "mediaGetResponse.json";
    String mediaID = "d1f1dafc-a124-4e0f-b808-9de53caf005c";

    expectResponse(fixtureName, 200);

    Media media = Media.getter(mediaID).get();

    assertEquals(mediaID, media.getMediaId());

    assertRequest("GET", "Media/%s/", mediaID);
  }


  @Test
  public void mediaListShouldSucceed() throws Exception {
    String fixtureName = "mediaListResponse.json";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(loadFixture(fixtureName))
    );

    Media.lister()
      .list();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("GET", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Media/", authId), recordedRequest.getPath());
  }

}
