package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;

public class CallGetter extends Getter<Call> {

  public CallGetter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<Call> obtainCall() {
    return client().getApiService().callGet(client().getAuthId(), id);
  }
}
