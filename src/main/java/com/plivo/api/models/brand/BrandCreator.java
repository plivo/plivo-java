


package com.plivo.api.models.brand;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class BrandCreator extends Creator<BrandCreateResponse> {
  private String brandAlias;
  private String profileUUID;
  private Boolean secondaryVetting;
  private String brandType;
  private String url;
  private String method;
  private String subaccountID;
  private String emailRecipients;
  private String campaignName;
  private String campaignUseCase;
  private String campaignUseCase;
  private String campaignDescription;
  private String sampleMessage1;
  private String sampleMessage2;
  private Boolean embeddedLink;
  private Boolean embeddedPhone;
  private Boolean numberPool;
  private Boolean ageGated;
  private Boolean directLending;
  private Boolean subscriberOptin;
  private Boolean subscriberOptout;
  private Boolean subscriberHelp;
  private Boolean affiliateMarketing;
  private String resellerID;

  
  BrandCreator(String brandAlias,String profileUUID,String brandType,Boolean secondaryVetting,String url,String method,String subaccountID,String emailRecipients,String campaignName,String campaignUseCase,String[] campaignSubUseCases,String campaignDescription,String sampleMessage1, String sampleMessage2,Boolean embeddedLink,Boolean embeddedPhone,Boolean numberPool,Boolean ageGated,Boolean directLending,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,Boolean affiliateMarketing,String resellerID) {
    this.brandAlias = brandAlias;
    this.profileUUID = profileUUID;
    this.brandType = brandType;
    this.secondaryVetting = secondaryVetting;
    this.url = url;
    this.method = method;
    this.subaccountID = subaccountID;
    this.emailRecipients = emailRecipients;
    this.campaignName = campaignName;
    this.campaignUseCase = campaignUseCase;
    this.campaignUseCase = campaignUseCase;
    this.campaignDescription = campaignDescription;
    this.sampleMessage1 = sampleMessage1;
    this.sampleMessage2 = sampleMessage2;
    this.embeddedLink = embeddedLink;
    this.embeddedPhone = embeddedPhone;
    this.numberPool = numberPool;
    this.ageGated = ageGated;
    this.directLending = directLending;
    this.subscriberOptin = subscriberOptin;
    this.subscriberOptout = subscriberOptout;
    this.subscriberHelp = subscriberHelp;
    this.affiliateMarketing = affiliateMarketing;
    this.resellerID = resellerID;
  }

  public String brandAlias() {
    return this.brandAlias;
  }

  public String profileUUID() {
    return this.profileUUID;
  }

  public String brandType() {
    return this.brandType;
  }

  public Boolean secondaryVetting(){
      return this.secondaryVetting;
  }

  public String url(){
    return this.url;
  }

  public String method(){
    return this.method;
  }

  public String subaccountID(){
    return this.subaccountID;
  }

  public String emailRecipients(){
    return this.emailRecipients;
  }
  
  public String campaignName(){
    return this.campaignName;
  }

  public String campaignUseCase(){
    return this.campaignUseCase;
  }

  public String[] campaignSubUseCases(){
    return this.campaignSubUseCases;
  }

  public String campaignDescription(){
    return this.campaignDescription;
  }

  public String sampleMessage1(){
    return this.sampleMessage1;
  }

  public String sampleMessage2(){
    return this.sampleMessage2;
  }

  public Boolean embeddedLink(){
    return this.embeddedLink;
  }
  
  public Boolean embeddedPhone(){
    return this.embeddedPhone;
  }

  public Boolean numberPool(){
    return this.numberPool;
  }

  public Boolean ageGated(){
    return this.ageGated;
  }

  public Boolean directLending(){
    return this.directLending;
  }

  public Boolean subscriberOptin(){
    return this.subscriberOptin;
  }
  
  public Boolean subscriberOptout(){
    return this.subscriberOptout;
  }

  public Boolean subscriberHelp(){
    return this.subscriberHelp;
  }

  public Boolean affiliateMarketing(){
    return this.affiliateMarketing;
  }
  
  public String resellerID(){
    return this.resellerID;
  }

  @Override
  protected Call<BrandCreateResponse> obtainCall() {
    return client().getApiService().createBrand(client().getAuthId(), this);
  }
}