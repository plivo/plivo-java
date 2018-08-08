package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberDeafDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberDeafDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService()
      .conferenceMemberDeafDelete(client().getPlivoRestClient().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberDeafDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }


}
