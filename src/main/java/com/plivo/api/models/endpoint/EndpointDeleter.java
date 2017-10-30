package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class EndpointDeleter extends Deleter<Endpoint> {

  public EndpointDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().endpointDelete(client().getAuthId(), id);
  }
}
