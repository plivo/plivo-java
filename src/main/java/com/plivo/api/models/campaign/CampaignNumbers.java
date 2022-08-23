package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignNumbers extends BaseResource{
   private String campaignID;
   private String campaignAlias;
   private String usecase;
   public PhoneNumbers[] phoneNumbers;
   private String message;

   public static CampaignNumberLinker link(String campaignID, String url,String method,String[] numbers) {
    return new CampaignNumberLinker(campaignID, numbers,url,method);
   }

   public static CampaignNumbersGetter getNumbers(String campaignID){
    return new CampaignNumbersGetter(campaignID);
  }

  public static CampaignNumberGetter getNumber(String campaignID){
   return new CampaignNumberGetter(campaignID);
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
 @Override
 public String getId() {
  return this.campaignID;
 }
}