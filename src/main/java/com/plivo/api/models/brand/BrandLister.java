package com.plivo.api.models.brand;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.MessagingBrandLister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.brand.Brand;


public class BrandLister extends MessagingBrandLister<Brand> {
  private Integer limit;
  private Integer offset;

  public BrandLister limit(Integer limit) {
    this.limit = limit;
    return this;

  }

  public BrandLister offset(Integer offset) {
    this.offset = offset;
    return this;

  }

  @Override
  protected Call<ListResponse<Brand>> obtainCall() {
    return client().getApiService().brandList(client().getAuthId(), toMap(), limit, offset);
  }
}