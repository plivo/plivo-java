package com.plivo.api.models.profile;

import com.plivo.api.models.base.MessagingDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ProfileDeleter extends MessagingDeleter<Profile> {

  public ProfileDeleter(String id) {
    super(id);
    if (id == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.id = id;
  }

  @Override
  protected Call<Profile> obtainCall() {
    return client().getApiService().profileDelete(client().getAuthId(), id);
  }

}