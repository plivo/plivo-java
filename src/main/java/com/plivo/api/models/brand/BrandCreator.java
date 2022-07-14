


package com.plivo.api.models.brand;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class BrandCreator extends Creator<BrandCreateResponse> {
  private String brandAlias;
  private String profileUUID;
  private Boolean secondaryVetting;
  private String brandType;

  
  BrandCreator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting) {
   
    this.brandAlias = brandAlias;
    this.profileUUID = profileUUID;
    this.brandType = brandType;
    this.secondaryVetting = secondaryVetting;

  }

  public String brandAlias() {
    return this.brandAlias;
  }

  public String profileUUID() {
    return this.profileUUID;
  }

  public String brandType() {
    return this.brandType;
  }

  public Boolean secondaryVetting(){
      return this.secondaryVetting;
  }

  @Override
  protected Call<BrandCreateResponse> obtainCall() {
    return client().getApiService().createBrand(client().getAuthId(), this);
  }
}