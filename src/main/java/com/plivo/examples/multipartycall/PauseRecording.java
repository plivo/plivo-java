package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class PauseRecording {

  public static void main(String[] args) throws IOException, PlivoRestException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can pause an MPC recording

    // 1. either by using static recordPause() method of MultiPartyCall class
    MultiPartyCall.recordPause(MultiPartyCallUtils.friendlyName("myRecordingMPC1")).trimSilence(true).update();

    // 2. or calling object method recordPause() of MultiPartyCall object
    MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myRecordingMPC2")).get().recordPause(true);
  }
}
