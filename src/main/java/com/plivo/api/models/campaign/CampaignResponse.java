package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.plivo.api.models.base.BaseResource;
import java.util.List;

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
                                                   
    @Override                                      
    public String getId() {                        
        return this.campaignID;                    
    }                                              
}