package com.plivo.api.models.tollfree_verification;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class TollfreeVerificationDeleter extends Deleter<TollfreeVerification> {

  public TollfreeVerificationDeleter(String uuid) {
    super(uuid);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().tollfreeVerificationDelete(client().getAuthId(), id);
  }


}