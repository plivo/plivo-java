package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackAddNumber extends Getter<Numbers> {

  private String number;
  private String uuid;

  public PowerpackAddNumber(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public PowerpackAddNumber number(String number) {
    this.number = number;
    return this;
  }

  @Override
  protected Call<Numbers> obtainCall() {
    if (number == null) {
      throw new IllegalArgumentException("number cannot be null");
    }
    return client().getApiService().powerpackAddNumberCreate(client().getAuthId(), uuid, number);
  }
}