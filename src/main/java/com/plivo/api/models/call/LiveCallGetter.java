package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class LiveCallGetter extends Getter<LiveCall> {

  public LiveCallGetter(String id) {
    super(id);
  }

  @Override
  protected Call<LiveCall> obtainCall() {
    return client().getApiService().liveCallGet(client().getAuthId(), id);
  }
}
