package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class StartMPC {

  public static void main(String[] args) throws IOException, PlivoRestException {
    Plivo.init("MANWVLYTK4ZWU1YTY4QA", "Y2Q2ZDgxZmY5YWRiOTI5YmQ1Njg0MTAxZWIyOTc4");

    // You can start an initialized MPC using

    // 1. either by using static starter() method of MultiPartyCall class
    MultiPartyCall.starter(MultiPartyCallUtils.friendlyName("myInitializedMPC1")).update();

    // 2. or calling object method start() of MultiPartyCall object
    MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myInitializedMPC2")).get().start();
  }
}
