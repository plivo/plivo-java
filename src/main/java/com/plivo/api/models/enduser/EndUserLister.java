package com.plivo.api.models.enduser;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class EndUserLister extends Lister<EndUser> {

   private String name = null;
   private String lastName = null;
   private String endUserType = null;

  public String name() {
    return this.name;
  }
  public String lastName() {
    return this.lastName;
  }
  public String endUserType() {
    return this.endUserType;
  }

  public EndUserLister name(final String name) {
    this.name = name;
    return this;
  }

  public EndUserLister lastName(final String lastName) {
    this.lastName = lastName;
    return this;
  }

  public EndUserLister endUserType(final String endUserType) {
    this.endUserType = endUserType;
    return this;
  }

    @Override
    protected Call<ListResponse<EndUser>> obtainCall() {
        return client().getApiService().endUserList(client().getAuthId(), toMap());
    }
}
