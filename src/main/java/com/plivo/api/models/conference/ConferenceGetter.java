package com.plivo.api.models.conference;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ConferenceGetter extends Getter<Conference> {

  public ConferenceGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Conference> obtainCall() {
    return client().getApiService().conferenceGet(client().getAuthId(), id);
  }
}
