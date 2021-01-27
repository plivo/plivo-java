package com.plivo.api.models.recording;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class RecordingDeleter extends VoiceDeleter<Recording> {

  public RecordingDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().recordingDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().recordingDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().recordingDelete(client().getAuthId(), id);
  }
}