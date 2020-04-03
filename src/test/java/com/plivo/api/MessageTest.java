package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

import com.plivo.api.models.message.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MessageTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageBuildShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);

    Message.creator("+911231231230", null, "text")
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageWithPowerpackShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);

    Message.creator(null, "text", "testUUID")
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageBuildWithClientShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);

    Message.creator("+911231231230", null, "text")
      .client(client)
      .create();
  }

  @Test
  public void messageCreateWithMMSClientShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    expectResponse(fixtureName, 202);

    Message.creator("+911231231230", Arrays.asList("+911231231330"), "test").type(MessageType.MMS).media_urls(new String[]{"https://test.com/hello.jpg"})
      .client(client)
      .create();

    assertRequest("POST", "Message/");
  }


  @Test(expected = IllegalArgumentException.class)
  public void messageWithPowerpackBuildWithClientShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Message.creator(null, "text", "testUUID")
      .client(client)
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageSendShouldFailWhenSameSrcDst() throws Exception {
    expectResponse("messageSendResponse.json", 202);

    Message.creator("+911231231230", Arrays.asList("+911231231230"), "test")
      .create();
  }


  @Test(expected = IllegalArgumentException.class)
  public void messageSendWithClientShouldFailWhenSameSrcDst() throws Exception {
    expectResponse("messageSendResponse.json", 202);

    Message.creator("+911231231230", Arrays.asList("+911231231230"), "test")
      .client(client)
      .create();
  }

  @Test
  public void messageCreateShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    expectResponse(fixtureName, 202);

    Message.creator("+911231231230", Arrays.asList("+911231231330"), "test")
      .create();

    assertRequest("POST", "Message/");
  }

  @Test
  public void messageWithPowerpackCreateShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    expectResponse(fixtureName, 202);

    Message.creator(Arrays.asList("+911231231330"), "test", "testUUID")
      .create();

    assertRequest("POST", "Message/");
  }

  @Test
  public void messageCreateWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    expectResponse(fixtureName, 202);

    Message.creator("+911231231230", Arrays.asList("+911231231330"), "test")
      .client(client)
      .create();

    assertRequest("POST", "Message/");
  }

  @Test
  public void messageWithPowerpackCreateWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    expectResponse(fixtureName, 202);

    Message.creator(Arrays.asList("+911231231330"), "test", "testUUID")
      .client(client)
      .create();

    assertRequest("POST", "Message/");
  }

  @Test
  public void messageGetShouldSucceed() throws Exception {
    String fixtureName = "messageGetResponse.json";
    String messageUuid = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";

    expectResponse(fixtureName, 200);

    Message message = Message.getter(messageUuid).get();

    assertEquals(message.getId(), message.getMessageUuid());

    assertRequest("GET", "Message/%s/", messageUuid);
    assertEquals(messageUuid, message.getMessageUuid());
  }

  @Test
  public void messageGetWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageGetResponse.json";
    String messageUuid = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";

    expectResponse(fixtureName, 200);

    Message message = Message.getter(messageUuid).client(client).get();

    assertEquals(message.getId(), message.getMessageUuid());

    assertRequest("GET", "Message/%s/", messageUuid);
    assertEquals(messageUuid, message.getMessageUuid());
  }

  @Test
  public void messageListShouldSucceed() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Message.lister()
      .messageDirection(MessageDirection.OUTBOUND)
      .messageState(MessageState.FAILED)
      .list();


    Map<String, String> params = new LinkedHashMap<>();
    params.put("message_direction", "outbound");
    params.put("message_state", "failed");

//    RecordedRequest recordedRequest = server.takeRequest();
//    assertEquals("GET", recordedRequest.getMethod());
//    assertEquals(String.format("/Account/%s/Message/", authId),
//      URI.create(recordedRequest.getPath()).getPath());

    assertRequest("GET", "Message/", params);
  }

  @Test
  public void messageListWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Message.lister()
      .messageDirection(MessageDirection.OUTBOUND)
      .messageState(MessageState.FAILED)
      .client(client)
      .list();


    Map<String, String> params = new LinkedHashMap<>();
    params.put("message_direction", "outbound");
    params.put("message_state", "failed");

//    RecordedRequest recordedRequest = server.takeRequest();
//    assertEquals("GET", recordedRequest.getMethod());
//    assertEquals(String.format("/Account/%s/Message/", authId),
//      URI.create(recordedRequest.getPath()).getPath());

    assertRequest("GET", "Message/", params);
  }

  @Test
  public void messageIteratorShouldSucceed() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();

    Iterator<Message> iter = Message.lister().iterator();
    iter.hasNext();
    iter.next();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Message/", params);
  }


  @Test
  public void messageIteratorWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();

    Iterator<Message> iter = Message.lister().client(client).iterator();
    iter.hasNext();
    iter.next();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Message/", params);
  }

  @Test
  public void messageIteratorShouldSucceed1() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();

    Iterator<Message> iter = Message.lister().iterator();
    iter.next();
    iter.hasNext();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Message/", params);
  }

  @Test
  public void messageIteratorWithClientShouldSucceed1() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> params = new LinkedHashMap<>();

    Iterator<Message> iter = Message.lister().client(client).iterator();
    iter.next();
    iter.hasNext();

    params.put("limit", "20");
    params.put("offset", "0");
    assertRequest("GET", "Message/", params);
  }
}
