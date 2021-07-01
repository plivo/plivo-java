package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class GetParticipant {

  public static void main(String[] args) throws PlivoValidationException, IOException, PlivoRestException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    MultiPartyCall.participantGetter(MultiPartyCallUtils.mpcUuid("18905d56-79c8-41d4-a840-25feff71070e"),
      "49").get();
  }
}
