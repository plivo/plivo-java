package com.plivo.api.models.profile;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ProfileGetter extends Getter<Profile> {

  public ProfileGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Profile> obtainCall() {
    return client().getApiService().profileGet(client().getAuthId(), id);
  }
}