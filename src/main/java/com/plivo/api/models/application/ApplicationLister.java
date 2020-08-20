package com.plivo.api.models.application;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class ApplicationLister extends Lister<Application> {

  private String subaccount;

  public String subaccount() {
    return this.subaccount;
  }

  public ApplicationLister subaccount(final String subaccount) {
    this.subaccount = subaccount;
    return this;
  }


  @Override
  protected Call<ListResponse<Application>> obtainCall() {
    return client().getApiService().applicationList(client().getAuthId(), toMap());
  }
}
