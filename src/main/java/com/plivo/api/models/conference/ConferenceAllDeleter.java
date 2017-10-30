package com.plivo.api.models.conference;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceAllDeleter extends Deleter<Conference> {

  public ConferenceAllDeleter() {
    super("");
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().conferenceDeleteAll(client().getAuthId());
  }
}
