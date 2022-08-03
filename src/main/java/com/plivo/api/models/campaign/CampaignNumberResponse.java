package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignNumberResponse {
    private String campaignID;
    private String campaignAlias;
    private String usecase;
    public CampaignNumbers[] phoneNumbers;

    public String getCampaignID() {
        return campaignID;
    }
    public String getCampaignAlias(){
        return campaignAlias;
    }

    public String getUsecase(){
        return usecase;
    }

    public CampaignNumbers[] getPhoneNumbers(){
        return phoneNumbers;
    }
}