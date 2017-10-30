package com.plivo.api.models.account;

import com.plivo.api.models.base.Getter;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class SubaccountGetter extends Getter<Subaccount> {

  public SubaccountGetter(String id) {
    super(id);

    if (!Utils.isSubaccountIdValid(id)) {
      throw new IllegalArgumentException("invalid subaccount ID");
    }
  }

  @Override
  protected Call<Subaccount> obtainCall() {
    return client().getApiService().subaccountGet(client().getAuthId(), id);
  }
}
