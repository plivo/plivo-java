package com.plivo.api.models.profile;

import com.plivo.api.models.base.BaseResponse;

public class ProfileADDResponse extends BaseResponse{
    private String apiID;
    private String profileUUID;
    private String message;
    private String error;

    public String getApiID() {
        return apiID;
    }

    public String getProfileUUID(){
        return profileUUID;
    }

    public String getMessage(){
        return message;
    }

    public String getError(){
        return error;
    }
}