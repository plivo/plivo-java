package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class StopRecording {

  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can stop recording for an MPC by

    // 1. either by using static stopper() method of MultiPartyCall class
    MultiPartyCall.recordStopper(MultiPartyCallUtils.friendlyName("myRecordingMPC1")).delete();

    // 2. or calling object method start() of MultiPartyCall object
    MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myRecordingMPC2")).get().recordStop();;
  }
}
