package com.plivo.api.models.brand;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.brand.Brand;


public class BrandLister extends Lister<Brand> {


  @Override
  protected Call<ListResponse<Brand>> obtainCall() {
    return client().getApiService().brandList(client().getAuthId(), toMap());
  }
}