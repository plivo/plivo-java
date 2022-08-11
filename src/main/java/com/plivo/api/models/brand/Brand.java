package com.plivo.api.models.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;
import java.util.List;

public class Brand extends BaseResource {  
  private String brandId;
  private BrandResponse brand;
  private List<Brand> brands;

  public List<Brand> getBrands() {
    return brands;
  }
  public static BrandCreator creator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting,String url,String method) {
    return new BrandCreator(brandAlias,profileUUID,brandType,secondaryVetting,url,method);
  }

  public static BrandGetter getter(String id) {
    return new BrandGetter(id);
  }

  public static BrandLister lister() {
    return new BrandLister();
  }
   
   @Override
  public String getId() {
    return this.brandId;
  }
  public BrandResponse getBrand() {
    return brand;
  }

}