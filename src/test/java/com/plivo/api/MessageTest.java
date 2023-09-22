package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.plivo.api.models.message.*;
import com.plivo.api.models.base.ListResponse;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class MessageTest extends BaseTest {

  private PlivoClient client;
  List<String> list = null;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageBuildShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);
    Message.creator("+911231231230", list, "text")
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageWithPowerpackShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);
    Message.creator(list, "text", "testUUID")
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageBuildWithClientShouldFailWithoutAllProps() throws Exception {
    expectResponse("messageSendResponse.json", 202);
    Message.creator("+911231231230", list, "text")
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
    Message.creator(list , "text", "testUUID")
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
  public void newmessageCreateShouldSucceed() throws Exception {
    String fixtureName = "messageSendResponse.json";

    expectResponse(fixtureName, 202);

    Message.creator("+911231231230", "+911231231330", "test")
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
    String requesterIP = "192.168.1.1";
    String expectedDLTEntityID = "1234";
    String expectedDLTTemplateID = "4567";
    String expectedDLTTemplateCategory = "service_implicit";
    String expectedConversationID = "9876";
    String expectedConversationOrigin = "utility";
    String expectedConversationExpirationTimestamp = "2023-08-03 23:02:00+05:30";
    expectResponse(fixtureName, 200);

    Message message = Message.getter(messageUuid).get();

    assertEquals(message.getId(), message.getMessageUuid());

    assertRequest("GET", "Message/%s/", messageUuid);
    assertEquals(messageUuid, message.getMessageUuid());
    assertEquals(requesterIP, message.getRequesterIP());
    assertEquals(expectedDLTEntityID, message.getDltEntityID());
    assertEquals(expectedDLTTemplateID, message.getDltTemplateID());
    assertEquals(expectedDLTTemplateCategory, message.getDltTemplateCategory());
    assertEquals(expectedConversationID, message.getConversationID());
    assertEquals(expectedConversationOrigin, message.getConversationOrigin());
    assertEquals(expectedConversationExpirationTimestamp, message.getConversationTimeStamp());
  }

  @Test
  public void messageGetWithClientShouldSucceed() throws Exception {
    String fixtureName = "messageGetResponse.json";
    String messageUuid = "5b40a428-bfc7-4daf-9d06-726c558bf3b8";
    String requesterIP = "192.168.1.1";
    expectResponse(fixtureName, 200);

    Message message = Message.getter(messageUuid).client(client).get();

    assertEquals(message.getId(), message.getMessageUuid());

    assertRequest("GET", "Message/%s/", messageUuid);
    assertEquals(messageUuid, message.getMessageUuid());
    assertEquals(requesterIP, requesterIP);
  }

  @Test
  public void messageListShouldSucceed() throws Exception {
    String fixtureName = "messageListResponse.json";
    String requesterIP1 = "192.168.1.1";
    String requesterIP2 = "192.168.1.20";

    String expectedDLTEntityID = "9596";
    String expectedDLTTemplateID = "0499";
    String expectedDLTTemplateCategory = "service_explicit";
    String expectedConversationID = "1234";
    String expectedConversationOrigin = "service";
    String expectedConversationExpirationTimestamp = "2023-08-03 23:02:00+05:30";
    expectResponse(fixtureName, 200);

    ListResponse<Message> response = Message.lister()
      .messageDirection(MessageDirection.OUTBOUND)
      .messageState(MessageState.FAILED)
      .list();


    Map<String, String> params = new LinkedHashMap<>();
    params.put("message_direction", "outbound");
    params.put("message_state", "failed");

    assertRequest("GET", "Message/", params);
    assertEquals(requesterIP1, response.getObjects().get(0).getRequesterIP());
    assertEquals(requesterIP2, response.getObjects().get(19).getRequesterIP());

    assertEquals(expectedDLTEntityID, response.getObjects().get(0).getDltEntityID());
    assertEquals(expectedDLTTemplateID, response.getObjects().get(0).getDltTemplateID());
    assertEquals(expectedDLTTemplateCategory, response.getObjects().get(0).getDltTemplateCategory());

    assertEquals("", response.getObjects().get(19).getDltEntityID());
    assertEquals("", response.getObjects().get(19).getDltTemplateID());
    assertEquals("", response.getObjects().get(19).getDltTemplateCategory());

    assertEquals(expectedConversationID, response.getObjects().get(0).getConversationID());
    assertEquals(expectedConversationOrigin, response.getObjects().get(0).getConversationOrigin());
    assertEquals(expectedConversationExpirationTimestamp, response.getObjects().get(0).getConversationTimeStamp());

    assertEquals("", response.getObjects().get(19).getConversationID());
    assertEquals("", response.getObjects().get(19).getConversationOrigin());
    assertEquals("", response.getObjects().get(19).getConversationTimeStamp());

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

    assertRequest("GET", "Message/", params);
  }

  @Test(expected = NoSuchMethodException.class)
  public void messageListTotalCountShouldFail() throws Exception {
    String fixtureName = "messageListResponse.json";

    expectResponse(fixtureName, 200);

    ListResponse<Message> response = Message.lister().list();

    Map<String, String> params = new LinkedHashMap<>();

    response.getMeta().getTotalCount();
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