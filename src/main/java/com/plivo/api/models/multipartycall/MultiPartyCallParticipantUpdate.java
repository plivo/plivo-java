package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceUpdater;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class MultiPartyCallParticipantUpdate extends VoiceUpdater<MultiPartyCallParticipantUpdateResponse> {

  private Boolean mute;
  private Boolean hold;
  private Boolean coachMode;

  public MultiPartyCallParticipantUpdate(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  public Boolean mute() {
    return mute;
  }

  public Boolean hold() {
    return hold;
  }

  public Boolean coachMode() {
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
  protected Call<MultiPartyCallParticipantUpdateResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    if (secondaryId.equalsIgnoreCase(MultiPartyCallUtils.allParticipants) && coachMode != null) {
      throw new PlivoValidationException("cannot update coachMode for all participants");
    }
    if (!Utils.anyNotNull(coachMode, mute, hold)) {
      throw new PlivoValidationException("please update either mute, hold or coach_mode");
    }
    return client().getVoiceApiService().mpcMemberUpdate(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallParticipantUpdateResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    if (secondaryId.equalsIgnoreCase(MultiPartyCallUtils.allParticipants) && coachMode != null) {
      throw new PlivoValidationException("cannot update coachMode for all participants");
    }
    if (!Utils.anyNotNull(coachMode, mute, hold)) {
      throw new PlivoValidationException("please update either mute, hold or coach_mode");
    }
    return client().getVoiceFallback1Service().mpcMemberUpdate(client().getAuthId(), id, secondaryId, this);
  }

  @Override
  protected Call<MultiPartyCallParticipantUpdateResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    if (secondaryId.equalsIgnoreCase(MultiPartyCallUtils.allParticipants) && coachMode != null) {
      throw new PlivoValidationException("cannot update coachMode for all participants");
    }
    if (!Utils.anyNotNull(coachMode, mute, hold)) {
      throw new PlivoValidationException("please update either mute, hold or coach_mode");
    }
    return client().getVoiceFallback2Service().mpcMemberUpdate(client().getAuthId(), id, secondaryId, this);
  }
}