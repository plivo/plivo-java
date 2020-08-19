package com.plivo.api.models.call;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;

public class CallDeleter extends VoiceDeleter<Call> {

  public CallDeleter(String id) {
    super(id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().callDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callDelete(client().getAuthId(), id);
  }

  @Override
  protected retrofit2.Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callDelete(client().getAuthId(), id);
  }
}
