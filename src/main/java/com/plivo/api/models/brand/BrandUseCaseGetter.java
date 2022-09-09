package com.plivo.api.models.brand;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class BrandUsecaseGetter extends Getter<BrandUsecase> {

  public BrandUsecaseGetter(String id) {
    super(id);
  }

  @Override
  protected Call<BrandUsecase> obtainCall() {
    return client().getApiService().brandUsecaseGet(client().getAuthId(), id);
  }
}
