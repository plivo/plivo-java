package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class MultiPartyCallParticipantRecordingPause extends VoiceUpdater<BaseResponse> {

  public MultiPartyCallParticipantRecordingPause(String mpcId, String secondaryId) {
    super(mpcId, secondaryId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcParticipantPauseRecording(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<BaseResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcParticipantPauseRecording(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<BaseResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcParticipantPauseRecording(client().getAuthId(), id, secondaryId);
  }
}