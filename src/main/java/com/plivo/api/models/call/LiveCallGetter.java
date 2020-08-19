package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class LiveCallGetter extends VoiceGetter<LiveCall> {

  public LiveCallGetter(String id) {
    super(id);
  }

  @Override
  protected Call<LiveCall> obtainCall() {
    return client().getVoiceApiService().liveCallGet(client().getAuthId(), id);
  }

  @Override
  protected Call<LiveCall> obtainFallback1Call() {
    return client().getVoiceFallback1Service().liveCallGet(client().getAuthId(), id);
  }

  @Override
  protected Call<LiveCall> obtainFallback2Call() {
    return client().getVoiceFallback2Service().liveCallGet(client().getAuthId(), id);
  }
}
