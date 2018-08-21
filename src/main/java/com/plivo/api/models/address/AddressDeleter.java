package com.plivo.api.models.address;

import com.plivo.api.models.application.Application;
import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class AddressDeleter extends Deleter<Application> {

  public AddressDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().addressDelete(client().getAuthId(), id);
  }
}

