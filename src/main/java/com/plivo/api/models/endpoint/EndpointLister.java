package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class EndpointLister extends VoiceLister<Endpoint> {

  @Override
  protected Call<ListResponse<Endpoint>> obtainCall() {
    return client().getVoiceApiService().endpointList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Endpoint>> obtainFallback1Call() {
    return client().getVoiceFallback1Service().endpointList(client().getAuthId(), toMap());
  }

  @Override
  protected Call<ListResponse<Endpoint>> obtainFallback2Call() {
    return client().getVoiceFallback2Service().endpointList(client().getAuthId(), toMap());
  }
}
