package com.plivo.api.models.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class Campaign extends BaseResource {
  
  private CampaignResponse campaign;

  public static CampaignCreator creator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,String sample1,String sample2) {
    return new CampaignCreator(name);
  }

  public static CampaignGetter getter(String campaignId) {
    return new CampaignGetter(campaignId);
  }

  public static CampaignLister lister() {
    return new CampaignLister();
  }

  public CampaignResponse getCampaign(){
      return this.campaign;
  }
}