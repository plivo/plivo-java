package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.models.base.BaseResource;

public class CampaignNumbers extends BaseResource{
   private String campaignID;
   private String campaignAlias;
   private String usecase;
   public PhoneNumbers[] phoneNumbers;

   public static CampaignNumberLinker creator(String campaignId, String[] numbers,String url,String method) {
    return new CampaignNumberLinker(campaignId, numbers,url,method);
   }

   public static CampaignNumbersGetter getNumbers(String id){
    return new CampaignNumbersGetter(id);
  }

  public static CampaignNumberGetter getNumber(String id){
   return new CampaignNumberGetter(id);
  }

   public String getCampaignID() {
        return campaignID;
    }
    public String getCampaignAlias(){
        return campaignAlias;
    }

    public String getUsecase(){
        return usecase;
    }

     public PhoneNumbers[] getPhoneNumbers(){
        return phoneNumbers;
    }
 @Override
 public String getId() {
  return this.campaignID;
 }
}