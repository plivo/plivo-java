package com.plivo.api.models.identity;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class IdentityDeleter extends Deleter<Identity> {

  public IdentityDeleter(String id){
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().identityDelete(client().getAuthId(), id);
  }
}
