package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class TollfreeVerificationGetter extends Getter<TollfreeVerification> {

  public TollfreeVerificationGetter(String id) {
    super(id);
  }

  @Override
  protected Call<TollfreeVerification> obtainCall() {
    return client().getApiService().tollfreeVerificationGet(client().getAuthId(), id);
  }
}