package com.plivo.api.models.powerpack;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class PowerpackNumberLister extends Lister<Numbers> {


  private String limit;
  private String offset;
  private String pattern;
  private String country_iso;
  private String type;
  private String id;
  private String service;

  PowerpackNumberLister(String id) {
    if (!Utils.allNotNull(id)) {
      throw new IllegalArgumentException("uuid cannot be null");
    }
    this.id = id;
  }

  public PowerpackNumberLister pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  public PowerpackNumberLister country_iso(String country_iso) {
    this.country_iso = country_iso;
    return this;
  }

  public PowerpackNumberLister type(String type) {
    this.type = type;
    return this;
  }

  public PowerpackNumberLister limit(String limit) {
    this.limit = limit;
    return this;
  }

  public PowerpackNumberLister offset(String offset) {
    this.offset = offset;
    return this;
  }

  public PowerpackNumberLister service(String service) {
    this.service = service;
    return this;
  }

  @Override
  protected Call<ListResponse<Numbers>> obtainCall() {
    return client().getApiService().powerpackNumberList(client().getAuthId(), id, toMap());
  }
}
