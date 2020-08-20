package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberMuteCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  public ConferenceMemberMuteCreator(String conferenceName, String memberId) {
    super(conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getApiService()
      .conferenceMemberMuteCreate(client().getAuthId(), conferenceName, memberId);
  }

  public ConferenceMemberActionResponse mute() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public ConferenceMemberMuteCreator client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
