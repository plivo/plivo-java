package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import com.plivo.api.validators.Validate;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallStopPlayAudio extends VoiceDeleter<MultiPartyCallParticipant> {
  public MultiPartyCallStopPlayAudio(String id, String secondaryId) {
    super(id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceApiService().mpcStopPlayAudio(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback1Service().mpcStopPlayAudio(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    Validate.check(this);
    return client().getVoiceFallback2Service().mpcStopPlayAudio(client().getAuthId(), id, secondaryId);
  }
}
