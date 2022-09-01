package com.plivo.api.models.campaign;

import com.plivo.api.models.base.MessagingDeleter;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import okhttp3.ResponseBody;

public class CampaignNumberUnlinker extends MessagingDeleter<CampaignNumbers> {
    private String campaignID;
    private String number;
    private String url;
    private String method;

    public CampaignNumberUnlinker(String campaignID, String number,String url,String method) {
        super(campaignID);
        this.campaignID = campaignID;
        this.number = number;
        this.url = url;
        this.method = method;
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


    @Override
    protected Call<CampaignNumbers> obtainCall() {
     return client().getApiService().unlinkCampaignNumber(client().getAuthId(), campaignID, number, url, method);
    }
}