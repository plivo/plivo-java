package com.plivo.api.models.multipartycall;

import com.plivo.api.models.base.BaseResponse;

import java.util.List;

public class MultiPartyCallParticipantAddResponse extends BaseResponse {

  private List<MultiPartyCallObjects> calls;
  private String requestUuid;

  public List<MultiPartyCallObjects> getCalls() {
    return calls;
  }

  public String getRequestUuid() {
    return requestUuid;
  }

  public static class MultiPartyCallObjects {
    private String to;
    private String from;
    private String callUuid;

    public String getTo() {
      return to;
    }

    public String getFrom() {
      return from;
    }

    public String getCallUuid() {
      return callUuid;
    }
  }
}