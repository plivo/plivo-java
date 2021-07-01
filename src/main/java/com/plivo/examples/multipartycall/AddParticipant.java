package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallParticipantAddResponse;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AddParticipant {

  public static void main(String[] args) throws IOException, PlivoRestException, InterruptedException, PlivoValidationException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");
    startNewMPCWithCustomer("<fromNumber>", "<toNumber>");
    startNewMPCBulkDialToAgents("<fromNumber>", "<toNumber1>", "<toNumber2>", "<toNumber3>");
    transferCallToMPC();
  }

  private static void startNewMPCWithCustomer(String fromNumber, String toNumber) throws IOException, PlivoRestException, PlivoValidationException {

    MultiPartyCallParticipantAddResponse resp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myMPC"),
      MultiPartyCallUtils.customer, fromNumber, Collections.singletonList(toNumber)).
      startMpcOnEnter(false).endMpcOnExit(true).maxDuration(1500).maxParticipants(7).record(true).update();

    System.out.println(resp.getMessage());
    System.out.printf("from number matches: %s", resp.getCalls().get(0).getFrom().equals(fromNumber));
  }

  private static void startNewMPCBulkDialToAgents(String fromNumber, String... toNumber) throws IOException, PlivoRestException, PlivoValidationException {

    MultiPartyCallParticipantAddResponse resp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myBulkMPC"),
      MultiPartyCallUtils.agent, fromNumber, Arrays.asList(toNumber)).startMpcOnEnter(false).
      endMpcOnExit(true).maxDuration(3840).maxParticipants(5).record(false).update();

    System.out.println(resp.getMessage());
    System.out.printf("1st destination number matches: %s", resp.getCalls().get(1).getFrom().equals(fromNumber));
    System.out.printf("2nd destination number matches: %s", resp.getCalls().get(0).getFrom().equals(fromNumber));
  }

  private static void transferCallToMPC() throws IOException, PlivoRestException, InterruptedException, PlivoValidationException {

    // First let's make a call
    CallCreateResponse resp = Call.creator("<from-number>", Collections.singletonList("<to-number>"), "<YOUR-ANSWER-URL>").create();

    // Mimicking callback to occur
    TimeUnit.SECONDS.sleep(10);

    // Now transfer this to an MPC
    MultiPartyCallParticipantAddResponse transferResp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myTransferMPC"), MultiPartyCallUtils.supervisor, resp.getRequestUuid()).update();
    System.out.printf("Transferred call from number matches original call: %s", transferResp.getCalls().get(0).getFrom().equalsIgnoreCase("<from-number>"));
  }
}
