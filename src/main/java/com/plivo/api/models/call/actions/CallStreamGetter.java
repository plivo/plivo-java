package com.plivo.api.models.call.actions;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class CallStreamGetter extends VoiceGetter<CallStreamGetSpecificResponse>  {

  public CallStreamGetter(String id) {
    super(id);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainCall() {
    return client().getVoiceApiService().callStreamGetAll(client().getAuthId(), id);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamGetAll(client().getAuthId(), id);
  }

  @Override
  protected Call<CallStreamGetSpecificResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamGetAll(client().getAuthId(), id);
  }
}
