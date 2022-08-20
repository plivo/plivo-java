package com.plivo.api.models.brand;

import com.plivo.api.models.base.MessagingListResponse;
import com.plivo.api.models.base.BrandsLister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.brand.Brand;


public class BrandLister extends BrandsLister<Brand> {


  @Override
  protected Call<MessagingListResponse<Brand>> obtainCall() {
    return client().getApiService().brandList(client().getAuthId(), toMap());
  }
}