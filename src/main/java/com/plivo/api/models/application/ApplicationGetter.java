package com.plivo.api.models.application;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ApplicationGetter extends Getter<Application> {

  public ApplicationGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Application> obtainCall() {
    return client().getApiService().applicationGet(client().getAuthId(), id);
  }
}
