package com.plivo.api.models.address;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class AddressGetter extends Getter<Address> {

  public AddressGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Address> obtainCall() {
    return client().getPlivoRestClient().getApiService()
      .addressGet(client().getPlivoRestClient().getAuthId(), id);
  }

}
