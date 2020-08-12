package com.plivo.api.models.conference;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceDeleter;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class ConferenceRecordDeleter extends VoiceDeleter<Conference> {

  public ConferenceRecordDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().conferenceRecordDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().conferenceRecordDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().conferenceRecordDelete(client().getAuthId(), id);
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
