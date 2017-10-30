package com.plivo.api.models.message;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class MessageGetter extends Getter<Message> {

  public MessageGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Message> obtainCall() {
    return client().getApiService().messageGet(client().getAuthId(), id);
  }
}
