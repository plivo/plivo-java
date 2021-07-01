package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallParticipantRecordingStop extends VoiceDeleter<MultiPartyCallParticipant> {

  public MultiPartyCallParticipantRecordingStop(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcParticipantRecordStop(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcParticipantRecordStop(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcParticipantRecordStop(client().getAuthId(), id, secondaryId);
  }
}