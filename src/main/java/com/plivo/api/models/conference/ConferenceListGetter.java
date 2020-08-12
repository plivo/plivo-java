package com.plivo.api.models.conference;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class ConferenceListGetter extends VoiceGetter<ConferenceList> {

  public ConferenceListGetter() {
    super("");
  }

  @Override
  protected Call<ConferenceList> obtainCall() {
    return client().getVoiceApiService().conferenceListGet(client().getAuthId());
  }

  @Override
  protected Call<ConferenceList> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceListGet(client().getAuthId());
  }

  @Override
  protected Call<ConferenceList> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceListGet(client().getAuthId());
  }
}
