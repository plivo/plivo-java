package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberDeleter extends ConferenceMemberDeleterAction {

  public ConferenceMemberDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberDelete(client().getAuthId(), conferenceName, id);
  }

  public void hangup() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public ConferenceMemberDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}