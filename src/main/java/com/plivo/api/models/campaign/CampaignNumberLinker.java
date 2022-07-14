package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignNumberLinker extends Creator<CampaignNumberLinkerUnlikerResponse> {
    private String[] numbers;
    private String url;
    private String method;
    private String subaccountID;

    CampaignNumberLinker(String[] numbers,String url,String method,String subaccountID) {
        this.numbers = numbers;
        this.url = url;
        this.method = method;
        this.subaccountID = subaccountID;
    }

    public String[] numbers(){
        return this.number;
    }

    public String url(){
        return this.url;
    }

    public String method(){
        return this.methos;
    }

    public String subaccountID(){
        return this.subaccountID;
    }

    @Override
    protected Call<CampaignNumberLinkerUnlikerResponse> obtainCall() {
     return client().getApiService().linkCampaignNumber(client().getAuthId(), id, this);
    }
}

