package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignResponse extends BaseResource{
    private String brandID;
    private String campaignID;
    private String resellerID;
    private String usecase;
    private String subUsecase;
    private String registrationStatus;
    private MnoMetadata mnoMetadata;
    private String sample1;
    private String sample2;
    private String description;
    private CampaignAttributes campaignAttributes;


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
     * @return sample1 return the sample1  
     */
    public String getSample1() {
        return sample1;                               
    }

    /**                                            
     * @return sample2 return the sample2
     */
    public String getSample2() {
        return sample2;                               
    }
    
    /**                                            
     * @return CampaignAttributes return the CampaignAttributes  
     */
    public CampaignAttributes getCampaignAttributes() {
        return campaignAttributes;                               
    }

    /**                                            
     * @return description return the description  
     */
    public String getDescription() {
        return description;                               
    }
                                              
                                                   
    @Override                                      
    public String getId() {                        
        return this.campaignID;                    
    }                                              
}