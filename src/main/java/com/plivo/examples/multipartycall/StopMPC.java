package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class StopMPC {

  public static void main(String[] args) throws IOException, PlivoRestException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can stop an initialized/active MPC

    // 1. either by using static stopper() method of MultiPartyCall class
    MultiPartyCall.stopper(MultiPartyCallUtils.friendlyName("myOngoingMPC1")).delete();

    // 2. or calling object method start() of MultiPartyCall object
    MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myOngoingMPC2")).get().stop();
  }
}
