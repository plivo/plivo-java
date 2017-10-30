package com.plivo.api.models.recording;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class RecordingDeleter extends Deleter<Recording> {

  public RecordingDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().recordingDelete(client().getAuthId(), id);
  }
}
