package com.plivo.examples.multipartycall;

import com.plivo.api.Plivo;
import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.multipartycall.MultiPartyCall;
import com.plivo.api.models.multipartycall.MultiPartyCallParticipant;
import com.plivo.api.models.multipartycall.MultiPartyCallParticipantList;
import com.plivo.api.models.multipartycall.MultiPartyCallUtils;

import java.io.IOException;

public class ListParticipants {

  public static void main(String[] args) throws IOException, PlivoRestException {
    Plivo.init("<YOUR-AUTH-ID>", "<YOUR-AUTH-TOKEN>");

    // You can list MPC participants by

    // 1. either by using static participantList() method of MultiPartyCall class
    MultiPartyCallParticipantList participantList1 = MultiPartyCall.participantList(MultiPartyCallUtils.mpcUuid("myMPCUuid1"));
    ListResponse<MultiPartyCallParticipant> resp1 = participantList1.callUuid("<your-call-uuid-1>").list();
    System.out.printf("Participants are properly fetched: %s", resp1.getObjects().stream().allMatch(p -> {
      try {
        return (p.getId().equals("myMPCUuid1") && p.getCallUuid().equals("<your-call-uuid-2>"));
      } catch (InvalidRequestException e) {
        e.printStackTrace();
        return false;
      }
    }));


    // 2. or calling object method participantList() of MultiPartyCall object
    MultiPartyCallParticipantList participantList2 = MultiPartyCall.getter(MultiPartyCallUtils.friendlyName("myMPCUuid2")).get().participantList();
    ListResponse<MultiPartyCallParticipant> resp2 = participantList2.callUuid("<your-call-uuid-2>").list();
    System.out.printf("Participants are properly fetched: %s", resp1.getObjects().stream().allMatch(p -> {
      try {
        return (p.getId().equals("myMPCUuid2") && p.getCallUuid().equals("<your-call-uuid-2>"));
      } catch (InvalidRequestException e) {
        e.printStackTrace();
        return false;
      }
    }));
  }
}
