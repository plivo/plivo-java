package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallParticipantKick extends VoiceDeleter<MultiPartyCallParticipant> {

  public MultiPartyCallParticipantKick(String mpcId, String participantId) {
    super(mpcId, participantId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcMemberKick(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcMemberKick(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcMemberKick(client().getAuthId(), id, secondaryId);
  }
}