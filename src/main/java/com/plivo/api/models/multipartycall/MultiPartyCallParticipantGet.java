package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class MultiPartyCallParticipantGet extends VoiceGetter<MultiPartyCallParticipant> {

  public MultiPartyCallParticipantGet(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  @Override
  protected Call<MultiPartyCallParticipant> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcMemberGet(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<MultiPartyCallParticipant> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcMemberGet(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<MultiPartyCallParticipant> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcMemberGet(client().getAuthId(), id, secondaryId);
  }
}