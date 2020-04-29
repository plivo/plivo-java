package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class FindTollfree extends Getter<Tollfree> {

  private String tollfree;
  private String uuid;

  public FindTollfree(String uuid) {
    super(uuid);
    if (uuid == null) {
      throw new IllegalArgumentException("powerpack uuid cannot be null");
    }
    this.uuid = uuid;
  }

  public FindTollfree tollfree(String tollfree) {
    this.tollfree = tollfree;
    return this;
  }

  @Override
  protected Call<Tollfree> obtainCall() {
    if (tollfree == null) {
      throw new IllegalArgumentException("number cannot be null");
    }
    return client().getApiService().powerpackFindTollfreeGet(client().getAuthId(), uuid, tollfree);
  }
}