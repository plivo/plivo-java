package com.plivo;
import java.io.IOException;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;
import com.plivo.api.models.call.CallUpdateResponse;
import com.plivo.api.models.call.LegSpecifier;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.call.LiveCall;
import com.plivo.api.models.call.LiveCallListResponse;
import com.plivo.api.models.call.QueuedCall;
import com.plivo.api.models.call.QueuedCallListResponse;
import com.plivo.api.models.call.actions.CallRecordCreateResponse;
import com.plivo.api.models.call.actions.CallPlayCreateResponse;
import com.plivo.api.models.call.actions.CallSpeakCreateResponse;
import com.plivo.api.models.call.actions.CallDtmfCreateResponse;
import com.plivo.api.models.conference.Conference;
import com.plivo.api.models.conference.ConferenceList;
import com.plivo.api.models.conference.ConferenceMemberActionResponse;
import com.plivo.api.models.conference.ConferenceRecordCreateResponse;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.recording.Recording;
import com.plivo.api.models.endpoint.Endpoint;
import com.plivo.api.models.endpoint.EndpointCreateResponse;
import com.plivo.api.models.endpoint.EndpointUpdateResponse;
import com.plivo.api.models.application.Application;
import com.plivo.api.models.application.ApplicationCreateResponse;
import com.plivo.api.models.application.ApplicationUpdateResponse;

class Example {
  public static void main(String [] args) {
    Plivo.init("MAMDJMMTEZOWY0ZMQWM2","OTljNmVmOGVkNGZhNjJlOWIyMWM0ZDI0ZjQwZDdk");
    try {
      // --- CALL 992e5aa2-99a0-4edc-8962-f23ba0d0cdd0  432e599b-dd6a-47c6-b5eb-70ecaa0cf07e c6731342-ba45-4891-a191-177d7cd22ab9 74256631-8bd4-469a-b812-d6a7d9c4a6bc 851e4062-8e9a-4e7b-89ea-8f8afc7f5b75
//      CallCreateResponse response = Call.creator("+919090909090", Collections.singletonList("sip:koushikqa119062465586783372208@phone-qa.voice.plivodev.com"), "https://plivobin.non-prod.plivops.com/api/v1/Conference_test07.xml")
//        .answerMethod("GET")
//        .create();
//      for(Integer i=0;i<10;i++) {
//        Call response = Call.getter("432e599b-dd6a-47c6-b5eb-70ecaa0cf07e")
//          .get();
//      }

//      CallUpdateResponse response = Call.updater("053db4b5-6f47-4655-a5f8-727378ae1f46")
//        .legs(LegSpecifier.ALEG)
//        .alegUrl("https://www.google.com")
//        .update();

//      Call.deleter("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0")
//        .delete();

      ListResponse<MultiPartyCall> response = MultiPartyCall.lister()
        .list();

//      MultiPartyCall response = MultiPartyCall.getter("uuid_ed657b05-1a62-4ed3-8b24-38e971e70c73")
//        .get();

//      LiveCall response = LiveCall.getter("0e29847b-4831-4479-a2e6-d9ef78e1c459")
//        .get();

//      LiveCallListResponse response = LiveCall.listGetter().get();

//      QueuedCall response = QueuedCall.getter("eba53b9e-8fbd-45c1-9444-696d2172fbc8")
//        .get();

//      QueuedCallListResponse response = QueuedCall.listGetter()
//        .get();

//      CallRecordCreateResponse response = Call.recorder("0e29847b-4831-4479-a2e6-d9ef78e1c459")
//        .record();

//      Call.recordStopper("0e29847b-4831-4479-a2e6-d9ef78e1c459")
//        .recordStop();

//      CallPlayCreateResponse response = Call.player("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0", Collections.singletonList("https://s3.amazonaws.com/plivocloud/Trumpet.mp3"))
//        .play();

//      Call.playStopper("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0")
//        .playStop();

//      CallSpeakCreateResponse response = Call.speaker("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0", "Hello World")
//        .speak();

//      Call.speakStopper("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0")
//        .speakStop();

//      CallDtmfCreateResponse response = Call.digitSender("992e5aa2-99a0-4edc-8962-f23ba0d0cdd0", "123886990665")
//        .sendDigits();


      // - CONFERENCE
//      Conference response = Conference.getter("FStestconference")
//        .get();

//      Conference.deleter("FStestconference")
//        .delete();

//      ConferenceList response = Conference.listGetter()
//        .get();

//      Conference.allDeleter()
//        .delete();

//      Conference.memberHangupper("FStestconference", "329")
//        .hangup();

//      ConferenceMemberActionResponse response = Conference.memberKicker("FStestconference", "344")
//        .kick();

//      ConferenceMemberActionResponse response = Conference.memberMuter("FStestconference", "329")
//        .mute();

//      Conference.memberMuteStopper("FStestconference", "329")
//        .stop();

//      ConferenceMemberActionResponse response = Conference.memberDeafer("FStestconference", "329")
//        .deaf();

//      Conference.memberDeafStopper("FStestconference", "329")
//        .stop();

//      ConferenceMemberActionResponse response = Conference.memberPlayer("FStestconference", "329", "https://s3.amazonaws.com/plivocloud/music.mp3")
//        .create();

//      Conference.memberPlayStopper("FStestconference", "329")
//        .stop();

//      ConferenceMemberActionResponse response = Conference.memberSpeaker("FStestconference", "329", "Hello World!")
//        .speak();

//      Conference.memberSpeakStopper("FStestconference", "329")
//        .delete();

//      ConferenceRecordCreateResponse response = Conference.recorder("FStestconference")
//        .record();

//      Conference.recordStopper("FStestconference")
//        .stop();


      // - RECORDING
//      Recording response = Recording.getter("6731117a-d6ff-11ea-85a2-06e58902d2c7")
//        .get();

//      ListResponse<Recording> response = Recording.lister()
//        .list();

//      Recording.deleter("6731117a-d6ff-11ea-85a2-06e58902d2c7").delete();


      // - ENDPOINT
//      EndpointCreateResponse response = Endpoint.creator("testusername", "testpassword", "Test Account")
//        .create();

//      Endpoint response = Endpoint.getter("299165884076307")
//        .get();

//      ListResponse<Endpoint> response = Endpoint.lister()
//        .list();

//      EndpointUpdateResponse response = Endpoint.updater("259119860764394")
//        .alias("Updated Endpoint Alias")
//        .update();

//      Endpoint.deleter("259119860764394")
//        .delete();


      // - APPLICATION
//      ApplicationCreateResponse response = Application.creator("Test Application").answerUrl("https://www.google.com")
//        .create();

//      Application response = Application.getter("19519831726035454")
//        .get();

//      ApplicationUpdateResponse response = Application.updater("19519831726035454")
//        .answerUrl("https://www.google.com")
//        .update();

//      Application.deleter("15428040232135419")
//        .delete();

//      ListResponse<Application> response = Application.lister()
//        .list();

      System.out.println(response);
    } catch (PlivoRestException | IOException | PlivoValidationException e) {
      e.printStackTrace();
    }
  }
}