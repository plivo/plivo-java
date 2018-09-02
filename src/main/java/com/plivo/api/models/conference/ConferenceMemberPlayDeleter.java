package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberPlayDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberPlayDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService()
      .conferenceMemberPlayDelete(client().getPlivoRestClient().getAuthId(), conferenceName, id);
  }

  @Override
  public ConferenceMemberPlayDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
