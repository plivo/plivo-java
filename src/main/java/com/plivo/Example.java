package com.plivo;
import java.io.IOException;
import java.util.Collections;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;

class Example {
  public static void main(String [] args) {
    Plivo.init("MAMDJMMTEZOWY0ZMQWM2","OTljNmVmOGVkNGZhNjJlOWIyMWM0ZDI0ZjQwZDdk");
    try {
      CallCreateResponse response = Call.creator("+919090909090", Collections.singletonList("sip:koushikqa119062465586783372208@phone-qa.voice.plivodev.com"), "https://plivobin.non-prod.plivops.com/api/v1/Conference_test07.xml")
        .answerMethod("GET")
        .create();

      System.out.println(response);
    } catch (PlivoRestException | IOException e) {
      e.printStackTrace();
    }
  }
}
