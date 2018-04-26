package com.plivo.api;

import static junit.framework.TestCase.assertEquals;

import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.LiveCall;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

public class CallTest extends BaseTest {

  @Test
  public void callCreateShouldSucceed() throws Exception {
    String fixtureName = "callCreateResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> headers = new HashMap<>();
    headers.put("test", "test");

    Call.creator("+911231231230", Arrays.asList("+911234567890", "+910987654321"),
      "http://example.answer.url/")
      .answerMethod("POST")
      .callerName("Test")
      .errorIfParentNotFound(true)
      .parentCallUuid("uuid")
      .fallbackMethod("POST")
      .fallbackUrl("http://example.answer.url/")
      .sipHeaders(headers)
      .create();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Call/", authId),
      recordedRequest.getPath());
  }

  @Test
  public void callCreateWithClientShouldSucceed() throws Exception {
    String fixtureName = "callCreateResponse.json";

    expectResponse(fixtureName, 200);

    Map<String, String> headers = new HashMap<>();
    headers.put("test", "test");
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.creator("+911231231230", Arrays.asList("+911234567890", "+910987654321"),
      "http://example.answer.url/")
      .answerMethod("POST")
      .callerName("Test")
      .errorIfParentNotFound(true)
      .parentCallUuid("uuid")
      .fallbackMethod("POST")
      .fallbackUrl("http://example.answer.url/")
      .sipHeaders(headers)
      .client(client)
      .create();

    RecordedRequest recordedRequest = server.takeRequest();
    assertEquals("POST", recordedRequest.getMethod());
    assertEquals(String.format("/Account/%s/Call/", authId),
      recordedRequest.getPath());
  }

  @Test(expected = IllegalArgumentException.class)
  public void callCreateShouldFailWithoutRequiredAttrs() throws Exception {
    Call.creator(null, null, null)
      .create();
  }

  @Test(expected = IllegalArgumentException.class)
  public void callCreateWithClientShouldFailWithoutRequiredAttrs() throws Exception {
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Call.creator(null, null, null)
      .client(client)
      .create();
  }

  @Test
  public void callListShouldSucceed() throws Exception {
    String fixtureName = "callListResponse.json";

    expectResponse(fixtureName, 200);

    Call.lister()
      .list();

    assertRequest("GET", "Call/");
  }

  @Test
  public void callListWithClientShouldSucceed() throws Exception {
    String fixtureName = "callListResponse.json";

    expectResponse(fixtureName, 200);
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.lister()
      .client(client)
      .list();

    assertRequest("GET", "Call/");
  }

  @Test
  public void callGetShouldSucceed() throws Exception {
    expectResponse("callGetResponse.json", 200);
    final String callId = "callId";

    Call call = Call.getter(callId)
      .get();

    assertEquals(call.getId(), call.getCallUuid());

    assertRequest("GET", "Call/%s/", callId);
  }

  @Test
  public void callGetWithClientShouldSucceed() throws Exception {
    expectResponse("callGetResponse.json", 200);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Call call = Call.getter(callId)
      .client(client)
      .get();

    assertEquals(call.getId(), call.getCallUuid());

    assertRequest("GET", "Call/%s/", callId);
  }

  @Test
  public void callDeleteShouldSucceed() throws Exception {
    expectResponse("callDeleteResponse.json", 204);
    final String callId = "callId";

    Call.deleter(callId)
      .delete();

    assertRequest("DELETE", "Call/%s/", callId);
  }

  @Test
  public void callDeleteWithClientShouldSucceed() throws Exception {
    expectResponse("callDeleteResponse.json", 204);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Call.deleter(callId)
      .client(client)
      .delete();

    assertRequest("DELETE", "Call/%s/", callId);
  }

  @Test
  public void callUpdateShouldSucceed() throws Exception {
    expectResponse("callUpdateResponse.json", 202);
    String callId = "callId";

    Call.updater(callId)
      .alegMethod("GET")
      .update();

    assertRequest("POST", "Call/%s/", callId);
  }

  @Test
  public void callUpdateWithClientShouldSucceed() throws Exception {
    expectResponse("callUpdateResponse.json", 202);
    String callId = "callId";

    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    Call.updater(callId)
      .alegMethod("GET")
      .client(client)
      .update();

    assertRequest("POST", "Call/%s/", callId);
  }

  @Test
  public void liveCallListGetShouldWork() throws Exception {
    expectResponse("liveCallListGetResponse.json", 200);

    LiveCall.listGetter()
      .get();

    Map<String, String> params = new LinkedHashMap<>();
    params.put("status", "live");
    assertRequest("GET", "Call/", params);
  }

  @Test
  public void liveCallListGetWithClientShouldWork() throws Exception {
    expectResponse("liveCallListGetResponse.json", 200);
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    LiveCall.listGetter()
      .client(client)
      .get();

    Map<String, String> params = new LinkedHashMap<>();
    params.put("status", "live");
    assertRequest("GET", "Call/", params);
  }

  @Test
  public void liveCallGetShouldWork() throws Exception {
    expectResponse("liveCallGetResponse.json", 200);
    final String callId = "callId";

    LiveCall liveCall = LiveCall.getter(callId)
      .get();

    assertEquals(liveCall.getId(), liveCall.getCallUuid());

    Map<String, String> params = new LinkedHashMap<>();
    params.put("status", "live");

    assertRequest("GET", "Call/%s/", params, callId);
  }

  @Test
  public void liveCallGetWithClientShouldWork() throws Exception {
    expectResponse("liveCallGetResponse.json", 200);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    LiveCall liveCall = LiveCall.getter(callId).client(client)
      .get();

    assertEquals(liveCall.getId(), liveCall.getCallUuid());

    Map<String, String> params = new LinkedHashMap<>();
    params.put("status", "live");

    assertRequest("GET", "Call/%s/", params, callId);
  }

  @Test
  public void callRecordCreateShouldWork() throws Exception {
    expectResponse("liveCallRecordCreateResponse.json", 202);
    final String callId = "callId";

    Call.recorder(callId)
      .record();

    assertRequest("POST", "Call/%s/Record/", callId);
  }

  @Test
  public void callRecordCreateWithClientShouldWork() throws Exception {
    expectResponse("liveCallRecordCreateResponse.json", 202);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.recorder(callId)
      .client(client)
      .record();

    assertRequest("POST", "Call/%s/Record/", callId);
  }

  @Test
  public void callRecordDeleteShouldWork() throws Exception {
    expectResponse("liveCallRecordDeleteResponse.json", 204);
    final String callId = "callId";

    Call.recordStopper(callId)
      .recordStop();

    assertRequest("DELETE", "Call/%s/Record/", callId);
  }

  @Test
  public void callRecordDeleteWithClientShouldWork() throws Exception {
    expectResponse("liveCallRecordDeleteResponse.json", 204);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.recordStopper(callId)
      .client(client)
      .recordStop();

    assertRequest("DELETE", "Call/%s/Record/", callId);
  }

  @Test
  public void callSpeakCreateShouldWork() throws Exception {
    expectResponse("liveCallSpeakCreateResponse.json", 202);
    final String callId = "callId";

    Call.speaker(callId, "test")
      .speak();

    assertRequest("POST", "Call/%s/Speak/", callId);
  }

  @Test
  public void callSpeakCreateWithClientShouldWork() throws Exception {
    expectResponse("liveCallSpeakCreateResponse.json", 202);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.speaker(callId, "test")
      .client(client)
      .speak();

    assertRequest("POST", "Call/%s/Speak/", callId);
  }

  @Test
  public void callSpeakDeleteShouldWork() throws Exception {
    expectResponse("liveCallSpeakDeleteResponse.json", 204);
    final String callId = "callId";

    Call.speakStopper(callId)
      .speakStop();

    assertRequest("DELETE", "Call/%s/Speak/", callId);
  }

  @Test
  public void callSpeakDeleteWithClientShouldWork() throws Exception {
    expectResponse("liveCallSpeakDeleteResponse.json", 204);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.speakStopper(callId)
      .client(client)
      .speakStop();

    assertRequest("DELETE", "Call/%s/Speak/", callId);
  }

  @Test
  public void callPlayCreateShouldWork() throws Exception {
    expectResponse("liveCallPlayCreateResponse.json", 202);
    final String callId = "callId";

    Call.player(callId, Collections.singletonList("http://url.to.music"))
      .play();

    assertRequest("POST", "Call/%s/Play/", callId);
  }

  @Test
  public void callPlayCreateWithClientShouldWork() throws Exception {
    expectResponse("liveCallPlayCreateResponse.json", 202);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.player(callId, Collections.singletonList("http://url.to.music"))
      .client(client)
      .play();

    assertRequest("POST", "Call/%s/Play/", callId);
  }

  @Test
  public void callPlayDeleteShouldWork() throws Exception {
    expectResponse("liveCallPlayDeleteResponse.json", 204);
    final String callId = "callId";

    Call.playStopper(callId)
      .playStop();

    assertRequest("DELETE", "Call/%s/Play/", callId);
  }

  @Test
  public void callPlayDeleteWithClientShouldWork() throws Exception {
    expectResponse("liveCallPlayDeleteResponse.json", 204);
    final String callId = "callId";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.playStopper(callId)
      .client(client)
      .playStop();

    assertRequest("DELETE", "Call/%s/Play/", callId);
  }

  @Test
  public void callDTMFCreateShouldWork() throws Exception {
    expectResponse("liveCallDtmfCreateResponse.json", 204);
    final String callId = "callId";
    final String digits = "1234";
    Call.digitSender(callId, digits).sendDigits();

    assertRequest("POST", "Call/%s/DTMF/", callId);
  }

  @Test
  public void callDTMFCreateWithClientShouldWork() throws Exception {
    expectResponse("liveCallDtmfCreateResponse.json", 204);
    final String callId = "callId";
    final String digits = "1234";
    PlivoClient client = new PlivoClient("MA123456789012345678", "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    Call.digitSender(callId, digits)
      .client(client)
      .sendDigits();

    assertRequest("POST", "Call/%s/DTMF/", callId);
  }


}
