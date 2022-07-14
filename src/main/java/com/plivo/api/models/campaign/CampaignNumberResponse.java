package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignNumbersResponse extends BaseResponse{
    private String campaignID;
    private String campaignAlias;
    private String usecase;
    private Numbers[] phoneNumbers;

    public String getCampaignID() {
        return campaignID;
    }
    public String getCampaignAlias(){
        return campaignAlias;
    }

    public String getUsecase(){
        return usecase;
    }

    public Numbers[] getPhoneNumbers(){
        return phoneNumbers;
    }
}