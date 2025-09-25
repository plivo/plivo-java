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
    private String messageFlow;
    private String helpMessage;
    private String optoutMessage;
    private String optinKeywords;
    private String optinMessage;
    private String optoutKeywords;
    private String helpKeywords;
    private String sample1;
    private String sample2;
    private String description;
    private String createdAt;
    private String campaignSource;
    private String errorReason;
    private String errorCode;
    private CampaignAttributes campaignAttributes;
    private String vertical;
    private String campaignAlias;
    private String errorDescription;



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

    public String getMessageFlow(){
    return this.messageFlow;
    }
    public String getHelpMessage(){
        return this.helpMessage;
    }

    public String getOptoutMessage(){
        return this.optoutMessage;
    }
    public String getOptinKeywords(){
        return this.optinKeywords;
    }

    public String getOptinMessage(){
        return this.optinMessage;
    }
    public String getOptoutKeywords(){
        return this.optoutKeywords;
    }
    public String getHelpKeywords(){
        return this.helpKeywords;
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

    /**
    * @return createdAt return the CreatedAt
    */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
    * @return createdAt return the CreatedAt
    */
    public String getCampaignSource() {
        return campaignSource;
    }

    /**
    * @return vertical return the vertical
    */
    public String getVertical() {
        return vertical;
    }

    /**
    * @return campaignAlias return the camp
aignAlias
    */
    public String getCampaignAlias() {
        return campaignAlias;
    }

    /**
    * @return errorCode return the errorCode
    */
    public String getErrorCode() {
        return errorCode;
    }

    /**
    * @return errorReason return the errorReason
    */
    public String getErrorReason() {
        return errorReason;
    }

    public String getErrorDescription() {
	    return errorDescription;
    }


                                                                                               
    @Override                                      
    public String getId() {                        
        return this.campaignID;                    
    }                                              
}
