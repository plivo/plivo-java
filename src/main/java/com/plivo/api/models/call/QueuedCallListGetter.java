package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class QueuedCallListGetter extends Getter<QueuedCallListResponse> {

  public QueuedCallListGetter() {
    super(""); // Special case where we don't care about the id
  }

  @Override
  protected Call<QueuedCallListResponse> obtainCall() {
    return client().getApiService().queuedCallListGet(client().getAuthId());
  }
}
