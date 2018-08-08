package com.plivo.api.models.phlo;

import com.plivo.api.models.base.Creator;
import retrofit2.Call;

public class PhloRunner extends Creator<PhloRunResponse> {

  private final String phloId;

  public PhloRunner(final String phloId){
    this.phloId = phloId;
  }

  @Override
  protected Call<PhloRunResponse> obtainCall() {
    return client().getPhloRestClient().getApiService().runPhlo(this.client().getPhloRestClient().getAuthId(), this.phloId);
  }
}
