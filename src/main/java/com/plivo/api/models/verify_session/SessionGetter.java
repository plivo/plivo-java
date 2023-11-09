package com.plivo.api.models.verify_session;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.message.Message;
import retrofit2.Call;

public class SessionGetter extends Getter<VerifySession> {
  public SessionGetter(String id) {
    super(id);
  }

  @Override
  protected Call<VerifySession> obtainCall() {
    return client().getApiService().sessionGet(client().getAuthId(), id);
  }
}
