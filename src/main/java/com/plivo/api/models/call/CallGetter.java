package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceGetter;

public class CallGetter extends VoiceGetter<Call> {

  public CallGetter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<Call> obtainCall() {
    return client().getVoiceApiService().callGet(client().getAuthId(), id);
  }

  protected retrofit2.Call<Call> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callGet(client().getAuthId(), id);
  }

  protected retrofit2.Call<Call> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callGet(client().getAuthId(), id);
  }
}
