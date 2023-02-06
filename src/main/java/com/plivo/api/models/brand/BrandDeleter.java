package com.plivo.api.models.brand;

import com.plivo.api.models.base.MessagingDeleter;
import retrofit2.Call;

public class BrandDeleter extends MessagingDeleter<BrandDeleteResponse>{

  public BrandDeleter(String id) {
    super(id);
    this.id = id;
  }

  @Override
  protected Call<BrandDeleteResponse> obtainCall() {
    return client().getApiService().brandDelete(client().getAuthId(), id);
  }

}
