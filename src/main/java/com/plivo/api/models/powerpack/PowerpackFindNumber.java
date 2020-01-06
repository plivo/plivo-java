package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackFindNumber extends Getter<Numbers> {

  private String number;
  private String uuid;

  public PowerpackFindNumber(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public PowerpackFindNumber number(String number) {
    this.number = number;
    return this;
  }

  @Override
  protected Call<Numbers> obtainCall() {
    if (number == null) {
      throw new IllegalArgumentException("number cannot be null");
    }
    return client().getApiService().powerpackFindNumberGet(client().getAuthId(), uuid, number);
  }
}