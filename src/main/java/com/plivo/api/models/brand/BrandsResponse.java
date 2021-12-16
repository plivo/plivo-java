package com.plivo.api.models.brand;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class BrandsResponse extends BaseResponse {

  List<Brand> brands;

  public List<Brand> getBrands() {
    return brands;
  }
}