package com.plivo.api.models.account;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class SubaccountLister extends Lister<Subaccount> {

  @Override
  protected Call<ListResponse<Subaccount>> obtainCall() {
    return client().getApiService().subaccountList(client().getAuthId(), limit, offset);
  }
}
