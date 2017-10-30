package com.plivo.api.models.conference;

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
}
