package com.plivo.api.models.brand;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class BrandCreateResponse extends BaseResponse {

  private BrandResponse brand;

  public BrandResponse brand() {
    return brand;
  }
}