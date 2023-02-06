package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;

public class CampaignUpdateResponse extends BaseResponse {
    
    private CampaignResponse campaign;
    
    public CampaignResponse getCampaign() {
        return campaign;
    }

}