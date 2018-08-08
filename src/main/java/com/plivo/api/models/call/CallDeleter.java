package com.plivo.api.models.call;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;

public class CallDeleter extends Deleter<Call> {

  public CallDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService().callDelete(client().getPlivoRestClient().getAuthId(), id);
  }
}
