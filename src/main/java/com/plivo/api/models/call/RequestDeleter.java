package com.plivo.api.models.call;

import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.exceptions.PlivoValidationException;
import com.plivo.api.models.base.VoiceDeleter;
import java.io.IOException;
import okhttp3.ResponseBody;

public class RequestDeleter extends VoiceDeleter<Call> {
  public RequestDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().requestDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().requestDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().requestDelete(client().getAuthId(), id);
  }

  public void cancel() throws IOException, PlivoRestException, PlivoValidationException {
    delete();
  }
}
