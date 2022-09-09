package com.plivo.api.models.campaign;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignAttributes {
    private Boolean embeddedLink;
    private Boolean embeddedPhone;
    private Boolean ageGated;
    private Boolean directLending;
    private Boolean subscriberOptin;
    private Boolean subscriberOptout;
    private Boolean subscriberHelp;
    private Boolean affiliateMarketing;
    


    /**
     * @return Boolean return the embeddedLink
     */
    public Boolean getEmbeddedLink() {
        return embeddedLink;
    }


    /**
     * @return Boolean return the embeddedPhone
     */
    public Boolean getEmbeddedPhone() {
        return embeddedPhone;
    }



    /**
     * @return Boolean return the ageGated
     */
    public Boolean getAgeGated() {
        return ageGated;
    }


    /**
     * @return Boolean return the directLending
     */
    public Boolean getDirectLending() {
        return directLending;
    }

    /**                                   
     * @return Boolean return the subscriberOptin
     */                                    
    public Boolean getSubscriberOptin() {        
        return subscriberOptin;                 
    }                                      
                                           
    /**                                    
     * @return Boolean return the subscriberOptout
     */                                            
    public Boolean getSubscriberOptout() {        
        return subscriberOptout;                 
    }                                              
                                                   
    /**                                            
     * @return Boolean return the subscriberHelp  
     */                                            
    public Boolean getSubscriberHelp() {          
        return subscriberHelp;                        
    }                                              
                                          
}