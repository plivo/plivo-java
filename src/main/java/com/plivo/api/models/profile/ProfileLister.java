package com.plivo.api.models.profile;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.profile.Profile;

public class ProfileLister extends Lister<Profile> {
  @Override
  protected Call<ListResponse<Profile>> obtainCall() {
    return client().getApiService().profileList(client().getAuthId(), toMap());
  }
}