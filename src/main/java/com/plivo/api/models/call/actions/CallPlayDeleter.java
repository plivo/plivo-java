package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceDeleter;
import com.plivo.api.models.call.Call;
import java.io.IOException;
import okhttp3.ResponseBody;

public class CallPlayDeleter extends VoiceDeleter<Call> {

  public CallPlayDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().callPlayDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callPlayDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callPlayDelete(client().getAuthId(), id);
  }

  public void playStop() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public CallPlayDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
