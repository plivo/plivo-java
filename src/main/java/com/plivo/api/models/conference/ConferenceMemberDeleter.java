package com.plivo.api.models.conference;

import com.plivo.api.Client;
import com.plivo.api.exceptions.PlivoRestException;

import java.io.IOException;
import retrofit2.Call;

public class ConferenceMemberDeleter extends ConferenceMemberDeleterAction {

  public ConferenceMemberDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ConferenceMemberActionResponse> obtainCall() {
    return client().getApiService()
      .conferenceMemberDelete(client().getAuthId(), conferenceName, id);
  }

  public void hangup() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public ConferenceMemberDeleter client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }

}