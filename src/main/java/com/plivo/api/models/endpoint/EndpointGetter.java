package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.VoiceGetter;
import retrofit2.Call;

public class EndpointGetter extends VoiceGetter<Endpoint> {

  public EndpointGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Endpoint> obtainCall() {
    return client().getVoiceApiService().endpointGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Endpoint> obtainFallback1Call() {
    return client().getVoiceFallback1Service().endpointGet(client().getAuthId(), id);
  }

  @Override
  protected Call<Endpoint> obtainFallback2Call() {
    return client().getVoiceFallback2Service().endpointGet(client().getAuthId(), id);
  }
}