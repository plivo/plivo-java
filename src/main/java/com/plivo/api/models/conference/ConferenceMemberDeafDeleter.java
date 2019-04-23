package com.plivo.api.models.conference;

import com.plivo.api.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberDeafDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberDeafDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService()
      .conferenceMemberDeafDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberDeafDeleter client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }


}
