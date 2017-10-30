package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class LiveCallListGetter extends Getter<LiveCallListResponse> {

  public LiveCallListGetter() {
    super(""); // Special case where we don't care about the id
  }

  @Override
  protected Call<LiveCallListResponse> obtainCall() {
    return client().getApiService().liveCallListGet(client().getAuthId());
  }
}
