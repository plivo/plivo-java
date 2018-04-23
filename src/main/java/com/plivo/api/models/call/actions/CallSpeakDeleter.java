package com.plivo.api.models.call.actions;

import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Deleter;
import com.plivo.api.models.call.Call;
import java.io.IOException;
import okhttp3.ResponseBody;

public class CallSpeakDeleter extends Deleter<Call> {

  public CallSpeakDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getApiService().callSpeakDelete(client().getAuthId(), id);
  }

  public void speakStop() throws IOException, PlivoRestException {
    delete();
  }

  @Override
  public CallSpeakDeleter client(final PlivoClient plivoClient) {
    this.plivoClient = plivoClient;
    return this;
  }

}
