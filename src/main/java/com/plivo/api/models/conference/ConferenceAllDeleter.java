package com.plivo.api.models.conference;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceAllDeleter extends VoiceDeleter<Conference> {

  public ConferenceAllDeleter() {
    super("");
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().conferenceDeleteAll(client().getAuthId());
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceDeleteAll(client().getAuthId());
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceDeleteAll(client().getAuthId());
  }
}
