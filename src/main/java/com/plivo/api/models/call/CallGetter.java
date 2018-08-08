package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;

public class CallGetter extends Getter<Call> {

  public CallGetter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<Call> obtainCall() {
    return client().getPlivoRestClient().getApiService().callGet(client().getPlivoRestClient().getAuthId(), id);
  }
}
