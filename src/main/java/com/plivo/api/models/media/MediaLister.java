package com.plivo.api.models.media;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.models.media.Media;
import retrofit2.Call;

public class MediaLister  extends Lister<Media> {
  @Override
  protected Call<ListResponse<Media>> obtainCall() {
    return client().getApiService().mediaList(client().getAuthId(), toMap());
  }
}