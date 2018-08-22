package com.plivo.api.models.identity;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class IdentityGetter extends Getter<Identity> {
  public IdentityGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Identity> obtainCall() {
    return client().getPlivoRestClient().getApiService()
      .identityGet(client().getPlivoRestClient().getAuthId(), id);
  }
}

