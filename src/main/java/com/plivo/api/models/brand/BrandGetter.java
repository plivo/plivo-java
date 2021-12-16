package com.plivo.api.models.brand;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class BrandGetter extends Getter<Brand> {

  public BrandGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Brand> obtainCall() {
    return client().getApiService().brandGet(client().getAuthId(), id);
  }
}
