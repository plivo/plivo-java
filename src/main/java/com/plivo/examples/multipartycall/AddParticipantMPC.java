package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.call.Call;
import com.plivo.api.models.call.CallCreateResponse;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallParticipantAddResponse;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class AddParticipantMPC {

  public static void main(String[] args) throws IOException, PlivoRestException, InterruptedException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");
    startNewMPC();
    startNewMPCBulkDial();
    transferCallToMPC();
  }

  private static void startNewMPC() throws IOException, PlivoRestException {

    MultiPartyCallParticipantAddResponse resp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myMPC"),
      MultiPartyCallUtils.customer, "<fromNumber>", Collections.singletonList("<toNumber>")).
      startMpcOnEnter(false).endMpcOnExit(true).maxDuration(1500).maxParticipants(7).record(true).update();

    System.out.println(resp.getMessage());
    System.out.printf("from number matches: %s", resp.getCalls().get(0).getFrom().equals("<fromNumber>"));
  }

  private static void startNewMPCBulkDial() throws IOException, PlivoRestException {

    MultiPartyCallParticipantAddResponse resp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myBulkMPC"),
      MultiPartyCallUtils.agent, "<fromNumber>", Arrays.asList("<agent-A-Number>", "<agent-B-Number>")).
      startMpcOnEnter(false).endMpcOnExit(true).maxDuration(3840).maxParticipants(5).record(false).update();

    System.out.println(resp.getMessage());
    System.out.printf("1st destination number matches: %s", resp.getCalls().get(1).getTo().equals("<agent-A-Number>"));
    System.out.printf("2nd destination number matches: %s", resp.getCalls().get(0).getTo().equals("<agent-B-Number>"));
  }

  private static void transferCallToMPC() throws IOException, PlivoRestException, InterruptedException {

    CallCreateResponse resp = Call.creator("<from-number>", Collections.singletonList("<to-number>"), "<YOUR-ANSWER-URL>").create();

    // Mimicking callback to occur
    TimeUnit.SECONDS.sleep(10);

    MultiPartyCallParticipantAddResponse transferResp = MultiPartyCall.addParticipant(MultiPartyCallUtils.friendlyName("myTransferMPC"), MultiPartyCallUtils.supervisor, resp.getRequestUuid()).update();
    System.out.printf("Transferred call from number matches original call: %s", transferResp.getCalls().get(0).getFrom().equalsIgnoreCase("<from-number>"));
  }
}
