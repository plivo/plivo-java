package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class QueuedCallListGetter extends VoiceGetter<QueuedCallListResponse> {

  public QueuedCallListGetter() {
    super(""); // Special case where we don't care about the id
  }

  @Override
  protected Call<QueuedCallListResponse> obtainCall() {
    return client().getVoiceApiService().queuedCallListGet(client().getAuthId());
  }

  @Override
  protected Call<QueuedCallListResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service().queuedCallListGet(client().getAuthId());
  }

  @Override
  protected Call<QueuedCallListResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service().queuedCallListGet(client().getAuthId());
  }
}
