package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceDeleter;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.call.Call;
import java.io.IOException;
import okhttp3.ResponseBody;

public class CallStreamDeleteSpecific extends VoiceDeleter<Call> {

  private String streamId;

  public CallStreamDeleteSpecific(String id, String streamId) {
    super(id, streamId);
    this.streamId = streamId;
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().callStreamDeleteSpecific(client().getAuthId(), id, streamId);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamDeleteSpecific(client().getAuthId(), id, streamId);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamDeleteSpecific(client().getAuthId(), id, streamId);
  }

  public void streamStopSpecific() throws IOException, PlivoRestException, PlivoValidationException {
    delete();
  }

  @Override
  public CallStreamDeleteSpecific client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

  public CallStreamDeleteSpecific streamId(final String streamId) {
    this.streamId = streamId;
    return this;
  }

}