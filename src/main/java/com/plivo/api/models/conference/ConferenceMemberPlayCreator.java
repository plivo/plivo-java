package com.plivo.api.models.conference;

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
    return client().getApiService()
      .conferenceMemberPlayCreate(client().getAuthId(), conferenceName, memberId, this);
  }

  public ConferenceMemberActionResponse play() throws IOException, PlivoRestException {
    return create();
  }
}
