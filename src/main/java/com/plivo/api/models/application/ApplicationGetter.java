package com.plivo.api.models.application;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class ApplicationGetter extends VoiceGetter<Application> {

  public ApplicationGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Application> obtainCall() {
    return client().getVoiceApiService().applicationGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Application> obtainFallback1Call() {
    return client().getVoiceFallback1Service().applicationGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Application> obtainFallback2Call() {
    return client().getVoiceFallback2Service().applicationGet(client().getAuthId(), id);
  }
}
