package com.plivo.api.models.media;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plivo.api.models.base.Getter;
import retrofit2.Call;
public class MediaGetter extends Getter<Media> {

@JsonIgnoreProperties(value = {"id"})
public MediaGetter(String id) {
  super(id);
  }

@Override
protected Call<Media> obtainCall() {
  return client().getApiService().mediaGet(client().getAuthId(), id);
  }
  }
