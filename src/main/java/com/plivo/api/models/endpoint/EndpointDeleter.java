package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.VoiceDeleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class EndpointDeleter extends VoiceDeleter<Endpoint> {

  public EndpointDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getVoiceApiService().endpointDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback1Call() {
    return client().getVoiceFallback1Service().endpointDelete(client().getAuthId(), id);
  }

  @Override
  protected Call<ResponseBody> obtainFallback2Call() {
    return client().getVoiceFallback2Service().endpointDelete(client().getAuthId(), id);
  }
}
