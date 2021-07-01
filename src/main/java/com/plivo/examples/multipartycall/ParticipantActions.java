package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.multipartycall.*;
import com.plivo.api.util.Utils;

import java.io.IOException;

public class ParticipantActions {

  public static void main(String[] args) throws IOException, PlivoRestException, PlivoValidationException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // Get participant by name and participantID
    MultiPartyCallParticipant participant = MultiPartyCall.participantGetter(MultiPartyCallUtils.friendlyName("myMPC"), "23").get();
    System.out.printf("Fetched correct participant: %s",
      (participant.getId().equals(MultiPartyCallUtils.friendlyName("myMPC"))
        && participant.getSecondaryId().equals("myMPC")));

    // Update participant by fetched resource
    MultiPartyCallParticipantUpdate updateAction = participant.update();
    MultiPartyCallParticipantUpdateResponse resp = updateAction.coachMode(true).hold(true).mute(true).update();
    Utils.anyNotNull(resp.getCoachMode(), resp.getHold(), resp.getMute());

    // Kick participant by fetched resource
    participant.kick();
  }
}
