package com.plivo.api.models.call.actions;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class CallStreamGetSpecific extends VoiceGetter<CallStreamGetSpecificResponse> {

  public CallStreamGetSpecific(String id, String streamId) {
    super(id, streamId);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainCall() {
    return client().getVoiceApiService().callStreamGetSpecific(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamGetSpecific(client().getAuthId(), id, secondaryId);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamGetSpecific(client().getAuthId(), id, secondaryId);
  }

}