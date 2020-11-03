package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class MultiPartyCallStop extends VoiceDeleter<MultiPartyCall> {

  public MultiPartyCallStop(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<ResponseBody> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcStop(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcStop(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcStop(client().getAuthId(), id);
  }
}