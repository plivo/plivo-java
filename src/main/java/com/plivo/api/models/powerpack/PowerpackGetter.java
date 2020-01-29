package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.PpkGetter;
import retrofit2.Call;

public class PowerpackGetter extends PpkGetter<Powerpack> {

  public PowerpackGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Powerpack> obtainCall() {
    return client().getApiService().powerpackGet(client().getAuthId(), id);
  }
}
