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
  public static BrandCreator creator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting,String url,String method,String subaccountID,String emailRecipients,String campaignName,String campaignUseCase,String[] campaignSubUseCases,String campaignDescription,String sampleMessage1, String sampleMessage2,Boolean embeddedLink,Boolean embeddedPhone,Boolean numberPool,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,Boolean affiliateMarketing,String resellerID) {
    return new BrandCreator(brandAlias,profileUUID,brandType,secondaryVetting,url,method,subaccountID,emailRecipients,campaignName,campaignUseCase,campaignSubUseCases,campaignDescription,sampleMessage1,sampleMessage2,embeddedLink,embeddedPhone,numberPool,ageGated,directLending,subscriberOptin,subscriberOptout,subscriberHelp,affiliateMarketing,resellerID);
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