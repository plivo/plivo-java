package com.plivo.api.models.application;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ApplicationDeleter extends Deleter<Application> {

  public ApplicationDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService().applicationDelete(client().getPlivoRestClient().getAuthId(), id);
  }
}
