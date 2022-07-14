package com.plivo.api.models.campaign;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;
import java.util.List;


public class Campaign extends BaseResource {
  private String campaignId;
  private CampaignResponse campaign;
  private List<CampaignResponse> campaigns;

  public List<CampaignResponse> getCampaigns() {
    return campaigns;
  }
  public static CampaignCreator creator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String resellerID,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,Boolean affiliateMarketing,String sample1,String sample2,String sample3,String sample4,String sample5,String url, String method, String subAccountID) {
    return new CampaignCreator(brandID,campaignAlias,vertical,usecase,subUsecases,resellerID,description,embeddedLink,embeddedPhone,ageGated,directLending,subscriberOptin,subscriberOptout,subscriberHelp,affiliateMarketing,sample1,sample2,sample3,sample4,sample5,url,method,subAccountID);
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

  public static CampaignNumberLinker creator(String[] numbers,String url,String method,String subaccountID) {
    return new CampaignNumberLinker(numbers,url,method,subaccountID);
  }

  public CampaignNumbersGetter getNumbers(){
    return new CampaignNumbersGetter(getId());
  }

  public CampaignNumberGetter getNumber(){
    return new CampaignNumberGetter(getId());
  }

 @Override
  public String getId() {
    return this.campaignId;
  }
}