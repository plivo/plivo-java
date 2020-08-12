package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class QueuedCallGetter extends VoiceGetter<QueuedCall> {

  public QueuedCallGetter(String id) {
    super(id);
  }

  @Override
  protected Call<QueuedCall> obtainCall() {
    return client().getVoiceApiService().queuedCallGet(client().getAuthId(), id);
  }

  @Override
  protected Call<QueuedCall> obtainFallback1Call() {
    return client().getVoiceFallback1Service().queuedCallGet(client().getAuthId(), id);
  }

  @Override
  protected Call<QueuedCall> obtainFallback2Call() {
    return client().getVoiceFallback2Service().queuedCallGet(client().getAuthId(), id);
  }
}
