package com.plivo.api.models.recording;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class RecordingGetter extends VoiceGetter<Recording> {

  public RecordingGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Recording> obtainCall() {
    return client().getVoiceApiService().recordingGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Recording> obtainFallback1Call() {
    return client().getVoiceFallback1Service().recordingGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Recording> obtainFallback2Call() {
    return client().getVoiceFallback2Service().recordingGet(client().getAuthId(), id);
  }
}
