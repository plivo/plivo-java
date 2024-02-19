package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignImportResponse extends BaseResponse{
    private String campaignID;
    public String getcampaignID(){
        return campaignID;
    }

}