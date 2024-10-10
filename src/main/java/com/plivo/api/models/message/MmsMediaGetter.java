package com.plivo.api.models.message;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class MmsMediaGetter extends Getter<MmsMedia> {

  public MmsMediaGetter(String id) {
	  super(id);
	  }

  @Override
  protected Call<MmsMedia> obtainCall() {
    return client().getApiService().mmsMediaGet(client().getAuthId(), id);
  }
}