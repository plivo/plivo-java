package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.BaseResponse;
import com.plivo.api.models.base.VoiceUpdater;
import retrofit2.Call;

import java.util.Collections;

public class MultiPartyCallStart extends VoiceUpdater<BaseResponse> {

  public MultiPartyCallStart(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<BaseResponse> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcStart(client().getAuthId(), id, Collections.singletonMap("status", "active"));
  }

  @Override
  protected Call<BaseResponse> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcStart(client().getAuthId(), id, Collections.singletonMap("status", "active"));
  }

  @Override
  protected Call<BaseResponse> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcStart(client().getAuthId(), id, Collections.singletonMap("status", "active"));
  }
}