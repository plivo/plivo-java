package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignNumberUnlinker extends Deleter<CampaignNumberLinkerUnlikerResponse> {
    private String number;
    private String url;
    private String method;
    private String subaccountID;

    CampaignNumberUnlinker(String id, String number,String url,String method,String subaccountID) {
        super(id);
        this.number = number;
        this.url = url;
        this.method = method;
        this.subaccountID = subaccountID;
    }

    public String number(){
        return this.number;
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
    protected Call<CampaignNumberLinkerUnlikerResponse> obtainCall() {
     return client().getApiService().unlinkCampaignNumber(client().getAuthId(), id, number, url, method, subaccountID);
    }
}