package com.plivo.api.models.conference;

import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceMemberSpeakDeleter extends ConferenceMemberDeleterAction<Conference> {

  public ConferenceMemberSpeakDeleter(String conferenceName, String id) {
    super(conferenceName, id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService()
      .conferenceMemberSpeakDelete(client().getAuthId(), conferenceName, id);
  }
}
