package com.plivo.api.models.conference;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceDeleter extends Deleter<Conference> {

  public ConferenceDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getPlivoRestClient().getApiService().conferenceDelete(client().getPlivoRestClient().getAuthId(), id);
  }
}
