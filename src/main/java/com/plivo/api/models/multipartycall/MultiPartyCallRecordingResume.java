package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

public class MultiPartyCallRecordingResume extends VoiceUpdater<BaseResponse> {

  public MultiPartyCallRecordingResume(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcResumeRecording(client().getAuthId(), id);
  }

  @Override
  protected Call<BaseResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcResumeRecording(client().getAuthId(), id);
  }

  @Override
  protected Call<BaseResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcResumeRecording(client().getAuthId(), id);
  }
}