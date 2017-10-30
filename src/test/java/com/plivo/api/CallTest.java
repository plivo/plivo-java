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

  @Test(expected = IllegalArgumentException.class)
  public void callCreateShouldFailWithoutRequiredAttrs() throws Exception {
    Call.creator(null, null, null)
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
  public void callGetShouldSucceed() throws Exception {
    expectResponse("callGetResponse.json", 200);
    final String callId = "callId";

    Call call = Call.getter(callId)
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
  public void callUpdateShouldSucceed() throws Exception {
    expectResponse("callUpdateResponse.json", 202);
    String callId = "callId";

    Call.updater(callId)
      .alegMethod("GET")
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
  public void callRecordCreateShouldWork() throws Exception {
    expectResponse("liveCallRecordCreateResponse.json", 202);
    final String callId = "callId";

    Call.recorder(callId)
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
  public void callSpeakCreateShouldWork() throws Exception {
    expectResponse("liveCallSpeakCreateResponse.json", 202);
    final String callId = "callId";

    Call.speaker(callId, "test")
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
  public void callPlayCreateShouldWork() throws Exception {
    expectResponse("liveCallPlayCreateResponse.json", 202);
    final String callId = "callId";

    Call.player(callId, Collections.singletonList("http://url.to.music"))
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
}
