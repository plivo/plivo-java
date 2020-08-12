package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberSpeakDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberSpeakDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberSpeakDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberSpeakDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberSpeakDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberSpeakDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
