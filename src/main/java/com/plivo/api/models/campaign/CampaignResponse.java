package com.plivo.api.models.campaign;

public class CampaignResponse extends BaseResponse{
    private String brandID;
    private String campaignID;
    private String resellerID;
    private String usecase;
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
     * @return MnoMetadata return the mnoMetadata
     */
    public MnoMetadata getMnoMetadata() {
        return mnoMetadata;
    }
}

public class MnoMetadata  {
    private OperatorDetail aTandT;
    private OperatorDetail verizonWireless;
    private OperatorDetail tMobile;
    private OperatorDetail uSCellular;
     /**
     * @return OperatorDetail return the aTandT
     */
    public OperatorDetail getATandT() {
        return aTandT;
    }

   

    /**
     * @return OperatorDetail return the verizonWireless
     */
    public OperatorDetail getVerizonWireless() {
        return verizonWireless;
    }

    

    /**
     * @return OperatorDetail return the tMobile
     */
    public OperatorDetail getTMobile() {
        return tMobile;
    }


    /**
     * @return OperatorDetail return the uSCellular
     */
    public OperatorDetail getUSCellular() {
        return uSCellular;
    }
}

public class OperatorDetail  {
    private String brandTier;
    private String tpm;
    /**
     * @return String return the brandTier
     */
    public String getBrandTier() {
        return brandTier;
    }

    /**
     * @return String return the tpm
     */
    public String getTpm() {
        return tpm;
    }

}