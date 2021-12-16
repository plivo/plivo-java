package com.plivo.api.models.brand;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.brand.BrandsResponse;


public class BrandLister extends Lister<BrandsResponse> {


  @Override
  protected Call<ListResponse<BrandsResponse>> obtainCall() {
    return client().getApiService().brandList(client().getAuthId(), toMap());
  }
}