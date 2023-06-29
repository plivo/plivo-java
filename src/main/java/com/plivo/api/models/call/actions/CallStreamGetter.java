package com.plivo.api.models.call.actions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.VoiceLister;
import retrofit2.Call;

public class CallStreamGetter extends VoiceLister<CallStreamGetSpecificResponse>  {

  @JsonIgnore
  private String callUuid;

  public CallStreamGetter(String id) {
    this.callUuid = id;
  }

  public String callUuid() {
    return callUuid;
  }

  @Override
  protected Call<ListResponse<CallStreamGetSpecificResponse>> obtainCall() {
    return client().getVoiceApiService().callStreamGetAll(client().getAuthId(), callUuid);
  }

  @Override
  protected Call<ListResponse<CallStreamGetSpecificResponse>> obtainFallback1Call() {
    return client().getVoiceFallback1Service().callStreamGetAll(client().getAuthId(), callUuid);
  }

  @Override
  protected Call<ListResponse<CallStreamGetSpecificResponse>> obtainFallback2Call() {
    return client().getVoiceFallback2Service().callStreamGetAll(client().getAuthId(), callUuid);
  }
}