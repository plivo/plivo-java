package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class PowerpackLister extends Lister<Powerpack> {


  private String limit;
  private String offset;


  public PowerpackLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public PowerpackLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<ListResponse<Powerpack>> obtainCall() {
    return client().getApiService().powerpackList(client().getAuthId(), toMap());
  }
}
