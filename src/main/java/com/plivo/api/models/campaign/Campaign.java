package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign extends BaseResource {
  private String brandID;
  private String campaignID;
  private String resellerID;
  private String usecase;
  private String subUsecase;
  private String registrationStatus;
  private MnoMetadata mnoMetadata;
  private CampaignResponse campaign;
  private String sample1;
  private String sample2;
  private String campaignDescription;
  private CampaignAttributes campaignAttributes;
  
  
  public static CampaignCreator creator(String brandID,String campaignAlias,String vertical,String usecase,String[] subUsecases,String description,Boolean embeddedLink,Boolean embeddedPhone,Boolean ageGated,Boolean directLending,Boolean affiliateMarketing,Boolean subscriberOptin,Boolean subscriberOptout,Boolean subscriberHelp,String sample1,String sample2,String url, String method) {
    return new CampaignCreator(brandID,campaignAlias,vertical,usecase,subUsecases,description,embeddedLink,embeddedPhone,ageGated,directLending,affiliateMarketing,subscriberOptin,subscriberOptout,subscriberHelp,sample1,sample2,url,method);
  }

  public static CampaignGetter getter(String id) {
    return new CampaignGetter(id);
  }

  public static CampaignLister lister() {
    return new CampaignLister();
  }

  /**
     * @return String return the brandID
     */
    public String getBrandID() {
      return brandID;
  }


  /**
   * @return String return the campaignID
   */
  public String getCampaignID() {
      return campaignID;
  }

  

  /**
   * @return String return the resellerID
   */
  public String getResellerID() {
      return resellerID;
  }


  /**
   * @return String return the usecase
   */
  public String getUsecase() {
      return usecase;
  }

   /**
   * @return String return the subUsecase
   */
  public String getSubUsecase() {
      return subUsecase;
  }

  /**
   * @return String return the registrationStatus
   */
  public String getRegistrationStatus() {
      return registrationStatus;
  }

  /**
   * @return MnoMetadata return the mnoMetadata
   */
  public MnoMetadata getMnoMetadata() {
      return mnoMetadata;
  }
  
  /**
   * @return String return the sample1
   */
  public String getSample1() {
      return sample1;
  }
  
  /**
   * @return String return the sample2
   */
  public String getSample2() {
      return sample2;
  }

  public CampaignResponse getCampaign() {
    return campaign;                               
  }

  public CampaignAttributes getCampaignAttributes() {
    return campaignAttributes;                               
  }

  public String getCampaignDescription() {
    return campaignDescription;                               
  }

 @Override
  public String getId() {
    return this.campaignID;
  }
}