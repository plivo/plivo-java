package com.plivo.api.models.multipartycall;

import com.plivo.api.models.base.BaseResponse;

public class MultiPartyCallParticipantUpdateResponse extends BaseResponse {

  private String hold;
  private String mute;
  private String coachMode;

  public String getHold() {
    return hold;
  }

  public String getMute() {
    return mute;
  }

  public String getCoachMode() {
    return coachMode;
  }
}