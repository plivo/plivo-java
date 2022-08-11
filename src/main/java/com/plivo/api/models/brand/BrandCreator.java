


package com.plivo.api.models.brand;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class BrandCreator extends Creator<BrandCreateResponse> {
  private String brandAlias;
  private String profileUUID;
  private Boolean secondaryVetting;
  private String brandType;
  private String url;
  private String method;
  
  BrandCreator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting,String url,String method) {
    this.brandAlias = brandAlias;
    this.profileUUID = profileUUID;
    this.brandType = brandType;
    this.secondaryVetting = secondaryVetting;
    this.url = url;
    this.method = method;
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

  public String url(){
    return this.url;
  }

  public String method(){
    return this.method;
  }

  @Override
  protected Call<BrandCreateResponse> obtainCall() {
    return client().getApiService().createBrand(client().getAuthId(), this);
  }
}