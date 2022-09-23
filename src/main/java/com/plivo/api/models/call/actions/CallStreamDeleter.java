package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.VoiceDeleter;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.call.Call;
import java.io.IOException;
import okhttp3.ResponseBody;

public class CallStreamDeleter extends VoiceDeleter<Call> {

  public CallStreamDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().callStreamDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamDelete(client().getAuthId(), id);
  }

  public void streamStop() throws IOException, PlivoRestException, PlivoValidationException {
    delete();
  }

  @Override
  public CallStreamDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}