package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;
public class CampaignResponse extends BaseResponse{
    private String brandID;
    private String campaignID;
    private String resellerID;
    private String usecase;
    private String subUsecase;
    private String registrationStatus;
    private MnoMetadata mnoMetadata;
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
}
