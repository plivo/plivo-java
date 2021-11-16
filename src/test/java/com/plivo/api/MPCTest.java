package com.plivo.api;

import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;
import org.junit.Before;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MPCTest extends BaseTest {

  private PlivoClient client;

  @Before
  public void setUp() throws Exception {
    super.setUp();
    client = new PlivoClient("MA123456789012345678",
      "Zmxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  }

  @Test
  public void listMPCs() throws Exception {
    expectResponse("mpcList.json", 200);
    Map<String, String> params = new LinkedHashMap<String, String>();
    params.put("status", MultiPartyCallUtils.ended);

    MultiPartyCall.lister().status(MultiPartyCallUtils.ended).list();

    assertRequest("GET", "MultiPartyCall/", params);
  }

  @Test
  public void listParticipantsMPC() throws Exception {
    expectResponse("mpcParticipantsList.json", 200);
    final String mpcUuid = "18905d56-79c8-41d4-a840-25feff71070e";

    MultiPartyCall.participantList(MultiPartyCallUtils.mpcUuid(mpcUuid)).list();

    assertRequest("GET", "MultiPartyCall/uuid_%s/Participant/", mpcUuid);
  }

  @Test
  public void getMPC() throws Exception {
    expectResponse("mpcGet.json", 200);
    final String mpcUuid = "18905d56-79c8-41d4-a840-25feff71070e";

    MultiPartyCall.getter(MultiPartyCallUtils.mpcUuid(mpcUuid)).get();

    assertRequest("GET", "MultiPartyCall/uuid_%s/", mpcUuid);
  }

  @Test
  public void getParticipantMPC() throws Exception {
    expectResponse("mpcParticipantGet.json", 200);
    final String mpcUuid = "18905d56-79c8-41d4-a840-25feff71070e";
    final String participantId = "49";

    MultiPartyCall.participantGetter(MultiPartyCallUtils.mpcUuid(mpcUuid), participantId).get();

    assertRequest("GET", "MultiPartyCall/uuid_%s/Participant/%s/", mpcUuid, participantId);
  }

  @Test
  public void addParticipant() throws Exception {
    expectResponse("mpcAddParticipant.json", 201);
    final String mpcName = "myMpc";
    final Map<String, Object> payload = new LinkedHashMap<String, Object>() {{
      put("role", "Agent");
      put("from", "12345");
      put("to", "67890<54321");
      put("caller_name", "developer");
      put("call_status_callback_method", "POST");
      put("confirm_key_sound_method", "GET");
      put("dial_music", "Real");
      put("ring_timeout", 80);
      put("delay_dial", 0);
      put("max_duration", 20000);
      put("max_participants", 10);
      put("wait_music_method", "GET");
      put("agent_hold_music_method", "GET");
      put("customer_hold_music_method", "GET");
      put("recording_callback_method", "GET");
      put("status_callback_method", "POST");
      put("on_exit_action_method", "POST");
      put("record", false);
      put("record_file_format", MultiPartyCallUtils.wav);
      put("status_callback_events", "mpc-state-changes,participant-state-changes");
      put("stay_alone", false);
      put("coach_mode", true);
      put("mute", false);
      put("hold", false);
      put("start_mpc_on_enter", true);
      put("end_mpc_on_exit", true);
      put("relay_dtmf_inputs", false);
      put("enter_sound", "beep:2");
      put("enter_sound_method", "GET");
      put("exit_sound", "beep:2");
      put("exit_sound_method", "POST");
    }};

    MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName(mpcName),
        MultiPartyCallUtils.agent, "12345", Arrays.asList("67890", "54321"))
      .ringTimeout(80)
      .enterSound("beep:2")
      .exitSoundMethod("POST")
      .endMpcOnExit(true)
      .recordFileFormat(MultiPartyCallUtils.wav)
      .maxDuration(20000)
      .callerName("developer")
      .update();

    assertRequestWithPayload("POST", "MultiPartyCall/name_%s/Participant/", payload, mpcName);
  }

  @Test
  public void updateParticipant() throws Exception {
    expectResponse("mpcParticipantUpdate.json", 202);
    final String mpcName = "myMpc";
    final String participantId = "88";
    final Map<String, Object> payload = new LinkedHashMap<String, Object>() {{
      put("coach_mode", false);
      put("mute", true);
    }};

    MultiPartyCall.participantUpdater(MultiPartyCallUtils.friendlyName(mpcName),
      participantId).mute(true).coachMode(false).update();
    assertRequestWithPayload("POST", "MultiPartyCall/name_%s/Participant/%s/",
      payload, mpcName, participantId);
  }

  @Test
  public void kickParticipant() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";
    final String participantId = "88";

    MultiPartyCall.participantKicker(MultiPartyCallUtils.friendlyName(mpcName), participantId).delete();
    assertRequest("DELETE", "MultiPartyCall/name_%s/Participant/%s/", mpcName, participantId);
  }

  @Test
  public void startMPC() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";

    MultiPartyCall.starter(MultiPartyCallUtils.friendlyName(mpcName)).update();

    assertRequestWithPayload("POST", "MultiPartyCall/name_%s/",
      Collections.singletonMap("status", "active"), mpcName);
  }

  @Test
  public void stopMPC() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";

    MultiPartyCall.stopper(MultiPartyCallUtils.friendlyName(mpcName)).delete();

    assertRequest("DELETE", "MultiPartyCall/name_%s/", mpcName);
  }

  @Test
  public void startRecording() throws Exception {
    expectResponse("mpcRecordStart.json", 202);
    final String mpcName = "myMpc";
    Map<String, Object> expectedPayload = new LinkedHashMap<>();
    expectedPayload.put("file_format", "mp3");
    expectedPayload.put("status_callback_method", "POST");

    MultiPartyCall.recordStarter(MultiPartyCallUtils.friendlyName(mpcName)).update();
    assertRequestWithPayload("POST", "MultiPartyCall/name_%s/Record/", expectedPayload, mpcName);
  }

  @Test
  public void stopRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";

    MultiPartyCall.recordStopper(MultiPartyCallUtils.friendlyName(mpcName)).delete();
    assertRequest("DELETE", "MultiPartyCall/name_%s/Record/", mpcName);
  }

  @Test
  public void pauseRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";

    MultiPartyCall.recordPause(MultiPartyCallUtils.friendlyName(mpcName)).update();
    assertRequest("POST", "MultiPartyCall/name_%s/Record/Pause/", mpcName);
  }

  @Test
  public void resumeRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "myMpc";

    MultiPartyCall.recordResume(MultiPartyCallUtils.friendlyName(mpcName)).update();
    assertRequest("POST", "MultiPartyCall/name_%s/Record/Resume/", mpcName);
  }

  @Test
  public void startParticipantRecording() throws Exception {
    expectResponse("mpcParticipantRecordStart.json", 200);
    final String mpcName = "mpMPC";
    final String participantId = "10";
    Map<String, Object> expectedPayload = new LinkedHashMap<>();
    expectedPayload.put("file_format", "mp3");
    expectedPayload.put("status_callback_method", "POST");

    MultiPartyCall.participantRecordStarter(MultiPartyCallUtils.friendlyName(mpcName), participantId).update();
    assertRequestWithPayload("POST", "MultiPartyCall/name_%s/Participant/%s/Record/", expectedPayload, mpcName, participantId);
  }

  @Test
  public void stopParticipantRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "mpMPC";
    final String participantId = "10";

    MultiPartyCall.participantRecordStopper(MultiPartyCallUtils.friendlyName(mpcName), participantId).delete();
    assertRequest("DELETE", "MultiPartyCall/name_%s/Participant/%s/Record/", mpcName, participantId);
  }

  @Test
  public void pauseParticipantRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "mpMPC";
    final String participantId = "10";
    MultiPartyCall.participantRecordPause(MultiPartyCallUtils.friendlyName(mpcName), participantId).update();
    assertRequest("POST", "MultiPartyCall/name_%s/Participant/%s/Record/Pause/", mpcName, participantId);
  }

  @Test
  public void resumeParticipantRecording() throws Exception {
    expectResponse(null, 204);
    final String mpcName = "mpMPC";
    final String participantId = "10";
    MultiPartyCall.participantRecordResume(MultiPartyCallUtils.friendlyName(mpcName), participantId).update();
    assertRequest("POST", "MultiPartyCall/name_%s/Participant/%s/Record/Resume/", mpcName, participantId);
  }

  @Test
  public void startPlayAudio() throws Exception {
    expectResponse("mpcStartPlayAudio.json",202);
    final String mpcName = "mpMPC";
    final String participantId = "10";
    Map<String, Object> expectedPayload = new LinkedHashMap<>();
    expectedPayload.put("url","https://s3.amazonaws.com/plivocloud/music.mp3");

    MultiPartyCall.startPlayAudio(MultiPartyCallUtils.friendlyName(mpcName),participantId).url("https://s3.amazonaws.com/plivocloud/music.mp3").update();
    assertRequestWithPayload("POST","MultiPartyCall/name_%s/Member/%s/Play/",expectedPayload,mpcName,participantId);
  }

  @Test
  public void stopPlayAudio() throws Exception {
    expectResponse(null,204);
    final String mpcName = "mpMPC";
    final String participantId = "10";

    MultiPartyCall.stopPlayAudio(MultiPartyCallUtils.friendlyName(mpcName),participantId).delete();
    assertRequest("DELETE","MultiPartyCall/name_%s/Member/%s/Play/",mpcName,participantId);
  }
}
