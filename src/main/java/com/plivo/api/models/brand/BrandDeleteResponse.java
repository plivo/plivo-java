package com.plivo.api.models.brand;

import com.plivo.api.models.base.BaseResource;

public class BrandDeleteResponse extends BaseResource{
  private String brandId;
  private String message;

  public String getBrandId() {
    return this.brandId;
  }

  public String getMessage(){
      return this.message;
  }

  @Override
  public String getId(){
      return this.brandId;
  }

}







