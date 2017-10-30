package com.plivo.api.models.conference;

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
}
