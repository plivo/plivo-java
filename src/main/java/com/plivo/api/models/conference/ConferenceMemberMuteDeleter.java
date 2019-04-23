package com.plivo.api.models.conference;

import com.plivo.api.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberMuteDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberMuteDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService()
      .conferenceMemberMuteDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberMuteDeleter client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }

}
