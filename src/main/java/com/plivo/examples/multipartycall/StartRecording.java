package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallRecordingStart;
import com.plivo.api.models.multipartycall.MultiPartyCallRecordingStartResponse;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class StartRecording {

  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can start recording for an MPC by

    // 1. either by using static recordStarter() method of MultiPartyCall class
    MultiPartyCallRecordingStart recordingStart1 = MultiPartyCall.recordStarter(MultiPartyCallUtils.friendlyName("myMPC1"));
    MultiPartyCallRecordingStartResponse resp1 = recordingStart1.fileFormat("wav").statusCallbackUrl("http://status/recording/").update();
    System.out.println(resp1.getRecordingUrl());
    System.out.println(resp1.getRecordingId());

    // 2. or calling object method start() of MultiPartyCall object
    MultiPartyCallRecordingStart recordingStart2 = MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myInitializedMPC2")).get().recordStarter();
    MultiPartyCallRecordingStartResponse resp2 = recordingStart2.fileFormat("mpc").update();
    System.out.println(resp2.getRecordingUrl());
    System.out.println(resp2.getRecordingId());
  }
}
