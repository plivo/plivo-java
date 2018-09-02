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
    return client().getPlivoRestClient().getApiService()
      .conferenceMemberPlayCreate(client().getPlivoRestClient().getAuthId(), conferenceName, memberId, this);
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
