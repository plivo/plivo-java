package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceRecordDeleter extends Deleter<Conference> {

  public ConferenceRecordDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().conferenceRecordDelete(client().getAuthId(), id);
  }

  public void stop() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public ConferenceRecordDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
