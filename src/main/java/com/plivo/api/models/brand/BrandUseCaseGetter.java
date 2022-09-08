package com.plivo.api.models.brand;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class BrandUseCaseGetter extends Getter<BrandUsecase> {

  public BrandGetter(String id) {
    super(id);
  }

  @Override
  protected Call<BrandUsecase> obtainCall() {
    return client().getApiService().brandUsecaseGet(client().getAuthId(), id);
  }
}
