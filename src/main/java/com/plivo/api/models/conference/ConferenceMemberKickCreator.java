package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberKickCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  public ConferenceMemberKickCreator(String conferenceName, String memberId) {
    super(conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getVoiceApiService()
      .conferenceMemberKickCreate(client().getAuthId(), conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback1Call() {
    return client().getVoiceFallback1Service()
      .conferenceMemberKickCreate(client().getAuthId(), conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainFallback2Call() {
    return client().getVoiceFallback2Service()
      .conferenceMemberKickCreate(client().getAuthId(), conferenceName, memberId);
  }

  public ConferenceMemberActionResponse kick() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public ConferenceMemberKickCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
