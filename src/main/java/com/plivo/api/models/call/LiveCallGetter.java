package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class LiveCallGetter extends Getter<LiveCall> {

  public LiveCallGetter(String id) {
    super(id);
  }

  @Override
  protected Call<LiveCall> obtainCall() {
    return client().getPlivoRestClient().getApiService().liveCallGet(client().getPlivoRestClient().getAuthId(), id);
  }
}
