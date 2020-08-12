package com.plivo.api.models.conference;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceDeleter extends VoiceDeleter<Conference> {

  public ConferenceDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().conferenceDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceDelete(client().getAuthId(), id);
  }
}
