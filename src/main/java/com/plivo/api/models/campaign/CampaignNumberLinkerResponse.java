package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignNumberLinkerUnlikerResponse extends BaseResponse{
    private String apiID;
    private String message;
    private String error;

    public String getApiID() {
        return apiID;
    }
    public String getMessage(){
        return message;
    }

    public String getError(){
        return error;
    }
}