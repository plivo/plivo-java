package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class TollfreeLister extends Lister<Tollfree> {


  private String limit;
  private String offset;
  private String id;

  TollfreeLister(String id) {

    if (!Utils.allNotNull(id)) {
      throw new IllegalArgumentException("uuid cannot be null");
    }
    this.id = id;
  }


  public TollfreeLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public TollfreeLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<ListResponse<Tollfree>> obtainCall() {
    return client().getApiService().powerpackTollfreeList(client().getAuthId(), id, toMap());
  }
}