package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignCreator extends Creator<CampaignCreateResponse> {
  private String brandID;
  private String campaignAlias;
  private String vertical;
  private String usecase;
  private String[] subUsecases;
  private String description;
  private Boolean embeddedLink;
  private Boolean embeddedPhone;
  private Boolean ageGated;
  private Boolean directLending;
  private Boolean subscriberOptin;
  private Boolean subscriberOptout;
  private Boolean subscriberHelp;
  private Boolean affiliateMarketing;
  private String sample1;
  private String sample2;
  private String url;
  private String method;
  private String messageFlow;
  private String helpMessage;
  private String optoutMessage;
  private String optinKeywords;
  private String optinMessage;
  private String optoutKeywords;
  private String helpKeywords;
  
  CampaignCreator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean affiliateMarketing, Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,String sample1,String sample2, String url, String method, String messageFlow, String helpMessage, String optoutMessage, String optinKeywords, String optinMessage, String optoutKeywords, String helpKeywords) {
   
    this.brandID = brandID;
    this.campaignAlias = campaignAlias;
    this.vertical = vertical;
    this.usecase = usecase;
    this.subUsecases = subUsecases;
    this.description = description;
    this.embeddedLink = embeddedLink;
    this.embeddedPhone = embeddedPhone;
    this.ageGated = ageGated;
    this.directLending = directLending;
    this.subscriberOptin = subscriberOptin;
    this.subscriberOptout = subscriberOptout;
    this.subscriberHelp = subscriberHelp;
    this.affiliateMarketing = affiliateMarketing;
    this.sample2 = sample2;
    this.sample1 = sample1;
    this.url = url;
    this.method = method;
    this.messageFlow = messageFlow;
    this.helpMessage = helpMessage;
    this.optoutMessage = optoutMessage;
    this.optinKeywords = optinKeywords;
    this.optinMessage = optinMessage;
    this.optoutKeywords = optoutKeywords;
    this.helpKeywords = helpKeywords;
  }

  public String brandID(){
      return this.brandID;
  }

  public String campaignAlias(){
      return this.campaignAlias;
  }

  public String vertical(){
      return this.vertical;
  }

  public String usecase(){
      return this.usecase;
  }

  public String description(){
      return this.description;
  }
  public String sample2(){
      return this.sample2;
  }
  public String sample1(){
      return this.sample1;
  }
  public Boolean affiliateMarketing(){
    return this.affiliateMarketing;
}
  public Boolean subscriberHelp(){
      return this.subscriberHelp;
  }
  public Boolean subscriberOptout(){
      return this.subscriberOptout;
  }
  public Boolean subscriberOptin(){
      return this.subscriberOptin;
  }
  public Boolean directLending(){
      return this.directLending;
  }
  public Boolean ageGated(){
      return this.ageGated;
  }
  public Boolean embeddedPhone(){
      return this.embeddedPhone;
  }
  public Boolean embeddedLink(){
      return this.embeddedLink;
  }
  public String url(){
    return this.url;
  }
  public String method(){
    return this.method;
  }
  
  public String messageFlow(){
    return this.messageFlow;
  }
  
  public String helpMessage(){
    return this.helpMessage;
  }

  public String optoutMessage(){
    return this.optoutMessage;
  }
  public String optinKeywords(){
    return this.optinKeywords;
  }

  public String optinMessage(){
    return this.optinMessage;
  }
  public String optoutKeywords(){
    return this.optoutKeywords;
  }
  public String helpKeywords(){
    return this.helpKeywords;
  }



  @Override
  protected Call<CampaignCreateResponse> obtainCall() {
    return client().getApiService().createCampaign(client().getAuthId(), this);
  }
}