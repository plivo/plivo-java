package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberPlayDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberPlayDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberPlayDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberPlayDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberPlayDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberPlayDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}