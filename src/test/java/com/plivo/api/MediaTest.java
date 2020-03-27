package com.plivo.api;

import static junit.framework.TestCase.assertEquals;
import static com.plivo.api.TestUtil.loadFixture;
import com.plivo.api.models.media.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

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
    String mediaID = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";

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
