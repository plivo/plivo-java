package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignNumbers extends BaseResource{
   private String campaignID;
   private String campaignAlias;
   private String usecase;
   public PhoneNumbers[] phoneNumbers;
   private String message;
   public HashMap<String, Integer> phoneNumbersSummary;
   public Integer numberPoolLimit;


   public static CampaignNumberLinker link(String campaignID, String url,String method,String[] numbers) {
    return new CampaignNumberLinker(campaignID, numbers,url,method);
   }

   public static CampaignNumbersGetter getNumbers(String campaignID){
    return new CampaignNumbersGetter(campaignID);
  }

  public static CampaignNumberGetter getNumber(String campaignID){
   return new CampaignNumberGetter(campaignID);
  }

  public static CampaignNumberUnlinker unlink(String campaignID, String number,String url,String method) {
    return new CampaignNumberUnlinker(campaignID, number,url,method);
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
    public String getMessage(){
        return message;
    }
    public HashMap<String, Integer> getPhoneNumbersSummary(){
        return phoneNumbersSummary;
    }
    public Integer getNumberPoolLimit(){
        return numberPoolLimit;
    }
 @Override
 public String getId() {
  return this.campaignID;
 }
}