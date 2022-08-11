package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Deleter;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import okhttp3.ResponseBody;

public class CampaignNumberUnlinker extends Deleter<Campaign> {
    private String number;
    private String url;
    private String method;
    private String subaccountID;

    public CampaignNumberUnlinker(String id, String number,String url,String method) {
        super(id);
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
    protected Call<ResponseBody> obtainCall() {
     return client().getApiService().unlinkCampaignNumber(client().getAuthId(), id, number, url, method, subaccountID);
    }
}