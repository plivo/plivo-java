package com.plivo.api.models.conference;

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
}
