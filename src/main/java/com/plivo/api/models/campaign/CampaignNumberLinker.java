package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Creator;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignNumberLinker extends Creator<CampaignNumberLinkerUnlinkerResponse> {
    private String campaignID;
    private String[] numbers;
    private String url;
    private String method;
    private String subaccountID;

    CampaignNumberLinker(String campaignID,String[] numbers,String url,String method,String subaccountID) {
        super();
        this.campaignID = campaignID;
        this.numbers = numbers;
        this.url = url;
        this.method = method;
        this.subaccountID = subaccountID;
    }

    public String[] numbers(){
        return this.numbers;
    }

    public String url(){
        return this.url;
    }

    public String method(){
        return this.method;
    }

    public String subaccountID(){
        return this.subaccountID;
    }

    @Override
    protected Call<CampaignNumberLinkerUnlinkerResponse> obtainCall() {
     return client().getApiService().linkCampaignNumber(client().getAuthId(), campaignID, this);
    }
}

