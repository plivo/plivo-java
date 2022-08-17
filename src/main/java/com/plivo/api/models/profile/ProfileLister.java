package com.plivo.api.models.profile;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.profile.Profile;

public class ProfileLister extends Lister<Profile> {
  private Integer limit;
  private Integer offset;

  public ProfileLister limit(Integer limit) {
    this.limit = limit;
    return this;

  }

  public ProfileLister offset(Integer offset) {
    this.offset = offset;
    return this;

  }


  @Override
  protected Call<ListResponse<Profile>> obtainCall() {
    return client().getApiService().profileList(client().getAuthId(), toMap(), limit, offset);
  }
}