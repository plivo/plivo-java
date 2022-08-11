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
  public static CampaignCreator creator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,String sample1,String sample2,String url, String method) {
    return new CampaignCreator(brandID,campaignAlias,vertical,usecase,subUsecases,description,embeddedLink,embeddedPhone,ageGated,directLending,subscriberOptin,subscriberOptout,subscriberHelp,sample1,sample2,url,method);
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

  public static CampaignNumberLinker creator(String campaignId, String[] numbers,String url,String method) {
    return new CampaignNumberLinker(campaignId, numbers,url,method);
  }

  public static CampaignNumberUnlinker delete(String campaignId, String number,String url,String method){
    return new CampaignNumberUnlinker(campaignId, number,url,method);
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