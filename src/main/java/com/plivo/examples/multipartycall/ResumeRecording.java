package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class ResumeRecording {

  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can resume recording for MPC by

    // 1. either by using static stopper() method of MultiPartyCall class
    MultiPartyCall.recordResume(MultiPartyCallUtils.friendlyName("myPausedRecordingMPC1")).update();

    // 2. or calling object method start() of MultiPartyCall object
    MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myPausedRecordingMPC2")).get().recordResume();
  }
}
