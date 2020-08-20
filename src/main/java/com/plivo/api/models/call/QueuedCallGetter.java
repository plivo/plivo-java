package com.plivo.api.models.call;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class QueuedCallGetter extends Getter<QueuedCall> {

  public QueuedCallGetter(String id) {
    super(id);
  }

  @Override
  protected Call<QueuedCall> obtainCall() {
    return client().getApiService().queuedCallGet(client().getAuthId(), id);
  }
}
