package com.plivo.api.models.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class Campaign extends BaseResource {
  private String campaignId;
  private CampaignResponse campaign;

  public static CampaignCreator creator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,String sample1,String sample2) {
    return new CampaignCreator(brandID,campaignAlias,vertical,usecase,subUsecases,description,embeddedLink,embeddedPhone,ageGated,directLending,subscriberOptin,subscriberOptout,subscriberHelp,sample1,sample2);
  }

  public static CampaignGetter getter(String id) {
    return new CampaignGetter(id);
  }

  public static CampaignLister lister() {
    return new CampaignLister();
  }

  public CampaignResponse getCampaign(){
      return this.campaign;
  }

 @Override
  public String getId() {
    return this.campaignId;
  }
}