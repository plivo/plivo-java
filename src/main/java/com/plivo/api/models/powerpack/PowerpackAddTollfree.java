package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class PowerpackAddTollfree extends Getter<Tollfree> {

  private String tollfree;
  private String uuid;

  public PowerpackAddTollfree(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public PowerpackAddTollfree tollfree(String tollfree) {
    this.tollfree = tollfree;
    return this;
  }

  @Override
  protected Call<Tollfree> obtainCall() {
    if (tollfree == null) {
      throw new IllegalArgumentException("tollfree cannot be null");
    }
    return client().getApiService().powerpackAddTollfreeCreate(client().getAuthId(), uuid, tollfree, this);
  }
}