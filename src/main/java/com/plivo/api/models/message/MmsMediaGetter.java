package com.plivo.api.models.message;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class MmsMediaGetter extends Getter<MmsMedia> {
  private String media_id;

  public MmsMediaGetter(String id, String media_id) {
    super(id);
    this.media_id = media_id;
  }

  @Override
  protected Call<MmsMedia> obtainCall() {
    return client().getApiService().mmsMediaGet(client().getAuthId(), id, media_id);
  }
}