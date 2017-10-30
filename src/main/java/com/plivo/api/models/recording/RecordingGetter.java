package com.plivo.api.models.recording;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class RecordingGetter extends Getter<Recording> {

  public RecordingGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Recording> obtainCall() {
    return client().getApiService().recordingGet(client().getAuthId(), id);
  }
}
