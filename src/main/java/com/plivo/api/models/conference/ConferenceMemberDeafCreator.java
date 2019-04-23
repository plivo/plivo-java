package com.plivo.api.models.conference;

import com.plivo.api.Client;
import com.plivo.api.exceptions.PlivoRestException;

import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberDeafCreator extends
  ConferenceMemberCreatorAction<ConferenceMemberActionResponse> {

  public ConferenceMemberDeafCreator(String conferenceName, String memberId) {
    super(conferenceName, memberId);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getApiService()
      .conferenceMemberDeafCreate(client().getAuthId(), conferenceName, memberId);
  }

  public ConferenceMemberActionResponse deaf() throws IOException, PlivoRestException {
    return create();
  }

  @Override
  public ConferenceMemberDeafCreator client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }


}
