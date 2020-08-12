package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberPlayCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  private final String url;

  public ConferenceMemberPlayCreator(String conferenceName, String memberId, String url) {
    super(conferenceName, memberId);
    this.url = url;
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberPlayCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberPlayCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberPlayCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  @Override
  public ConferenceMemberPlayCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  public ConferenceMemberActionResponse play() throws IOException, PlivoRestException {
    return create();
  }
}
