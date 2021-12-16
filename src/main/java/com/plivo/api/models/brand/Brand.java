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
  public static BrandCreator creator(String altBusinessIDType,String altBusinessID, String city,String companyName,String country,String ein,String einIssuingCountry,String email,String entityType,String firstName,String lastName,String phone,String postalCode,String registrationStatus,String state,String stockExchange,String stockSymbol, String street, String vertical,String website,String secondaryVetting) {
    return new BrandCreator(altBusinessIDType,altBusinessID,city,companyName,country,ein,einIssuingCountry,email,entityType,firstName,lastName,phone,postalCode,registrationStatus,state,stockExchange,stockSymbol, street, vertical,website,secondaryVetting);
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