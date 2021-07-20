package com.plivo.api.models.multipartycall;

import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class MultiPartyCallGet extends VoiceGetter<MultiPartyCall> {

  public MultiPartyCallGet(String mpcId) {
    super(mpcId);
  }

  @Override
  protected Call<MultiPartyCall> obtainCall() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceApiService().mpcGet(client().getAuthId(), id);
  }

  @Override
  protected Call<MultiPartyCall> obtainFallback1Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback1Service().mpcGet(client().getAuthId(), id);
  }

  @Override
  protected Call<MultiPartyCall> obtainFallback2Call() throws PlivoValidationException {
    MultiPartyCallUtils.validMultiPartyCallId(id);
    return client().getVoiceFallback2Service().mpcGet(client().getAuthId(), id);
  }
}