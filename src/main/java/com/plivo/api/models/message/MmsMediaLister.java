package com.plivo.api.models.message;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class MmsMediaLister extends Lister<MmsMedia> {

  private String id;

  public MmsMediaLister(String id) {
    this.id = id;
  }

  @Override
  protected Call<ListResponse<MmsMedia>> obtainCall() {
    return client().getApiService().mmsMediaList(client().getAuthId(), id, toMap());
  }
}