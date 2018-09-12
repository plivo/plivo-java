package com.plivo.api.models.identity;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class IdentityLister extends Lister<Identity> {
  @Override
  protected Call<ListResponse<Identity>> obtainCall() {
    return client().getApiService().identityList(client().getAuthId(), toMap());
  }
}
