package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.InvalidRequestException;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;

public class MultiPartyCallParticipantUpdate extends Updater<MultiPartyCallParticipantUpdateResponse> {

  private Boolean mute;
  private Boolean hold;
  private Boolean coachMode;

  public MultiPartyCallParticipantUpdate(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  public Boolean getMute() {
    return mute;
  }

  public Boolean getHold() {
    return hold;
  }

  public Boolean getCoachMode() {
    return coachMode;
  }

  public MultiPartyCallParticipantUpdate mute(Boolean mute) {
    this.mute = mute;
    return this;
  }

  public MultiPartyCallParticipantUpdate hold(Boolean hold) {
    this.hold = hold;
    return this;
  }

  public MultiPartyCallParticipantUpdate coachMode(Boolean coachMode) {
    this.coachMode = coachMode;
    return this;
  }

  @Override
  protected Call<MultiPartyCallParticipantUpdateResponse> obtainCall() throws InvalidRequestException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getApiService().mpcMemberUpdate(client().getAuthId(), id, secondaryId, this);
  }
}
