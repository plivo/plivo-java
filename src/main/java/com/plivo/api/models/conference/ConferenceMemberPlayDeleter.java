package com.plivo.api.models.conference;

import com.plivo.api.Client;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberPlayDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberPlayDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService()
      .conferenceMemberPlayDelete(client().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberPlayDeleter client(final Client plivoClient) {
    this.client = plivoClient;
    return this;
  }

}
