package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class GetMPC {
  public static void main(String[] args) throws IOException, PlivoRestException {

    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // Fetch specific MultiPartyCall
    MultiPartyCall mpc = MultiPartyCall.getter(MultiPartyCallUtils.mpcUuid("<YOUR-MPC-UUID>")).get();
    System.out.println((mpc.getMpcUuid().equals("<YOUR-MPC-UUID>")));
  }
}
