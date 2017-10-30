package com.plivo.api;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import com.plivo.api.models.message.Message;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import org.junit.Test;

public class PlivoClientTest extends BaseTest {
  @Test
  public void clientShouldSendCorrectUserAgent() throws Exception {
    String fixtureName = "messageGetResponse.json";
    String messageUuid = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";

    expectResponse(fixtureName, 200);

    Message message = Message.getter(messageUuid).get();

    RecordedRequest request = this.server.takeRequest();
    assertTrue(request.getHeader("User-Agent").toLowerCase().contains("plivo-java"));
  }
}
