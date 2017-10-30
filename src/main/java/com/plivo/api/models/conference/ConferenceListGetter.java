package com.plivo.api.models.conference;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class ConferenceListGetter extends Getter<ConferenceList> {

  public ConferenceListGetter() {
    super("");
  }

  @Override
  protected Call<ConferenceList> obtainCall() {
    return client().getApiService().conferenceListGet(client().getAuthId());
  }
}
