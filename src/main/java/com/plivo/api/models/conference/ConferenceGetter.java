package com.plivo.api.models.conference;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class ConferenceGetter extends VoiceGetter<Conference> {

  public ConferenceGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Conference> obtainCall() {
    return client().getVoiceApiService().conferenceGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Conference> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Conference> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceGet(client().getAuthId(), id);
  }
}