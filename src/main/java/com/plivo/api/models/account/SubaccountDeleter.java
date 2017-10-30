package com.plivo.api.models.account;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.util.Utils;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class SubaccountDeleter extends Deleter<Subaccount> {

  public SubaccountDeleter(String id) {
    super(id);

    if (!Utils.isSubaccountIdValid(id)) {
      throw new IllegalArgumentException("invalid subaccount ID");
    }
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().subaccountDelete(client().getAuthId(), id);
  }
}
