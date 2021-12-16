package com.plivo.api.models.brand;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class Brand extends BaseResource {  
  private BrandResponse brand;

  public static BrandCreator creator(String altBusinessIDType,String altBusinessID, String city,String companyName,String country,String ein,String einIssuingCountry,String email,String entityType,String firstName,String lastName,String phone,String postalCode,String registrationStatus,String state,String stockExchange,String stockSymbol, String street, String vertical,String website,String secondaryVetting) {
    return new BrandCreator(name);
  }

  public static BrandGetter getter(String brandId) {
    return new BrandGetter(brandId);
  }

  public static BrandLister lister() {
    return new BrandLister();
  }
   
  public BrandResponse getBrand() {
    return brand;
  }

}