package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberMuteDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberMuteDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService()
      .conferenceMemberMuteDelete(client().getPlivoRestClient().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberMuteDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
