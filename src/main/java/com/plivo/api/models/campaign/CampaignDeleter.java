package com.plivo.api.models.campaign;

import com.plivo.api.models.base.MessagingDeleter;
import retrofit2.Call;

public class CampaignDeleter extends MessagingDeleter<CampaignDeleteResponse> {

  public CampaignDeleter(String id) {
    super(id);
  }

  @Override
  protected Call<CampaignDeleteResponse> obtainCall() {
    return client().getApiService().campaignDelete(client().getAuthId(), id);
  }
}

