package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Deleter;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class CampaignDeleter extends Deleter<Campaign> {

  public CampaignDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<ResponseBody> obtainCall() {
    return client().getApiService().campaignDelete(client().getAuthId(), id);
  }
}

