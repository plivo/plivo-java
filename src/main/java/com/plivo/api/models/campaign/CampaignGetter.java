package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class CampaignGetter extends Getter<Campaign> {

  public CampaignGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Campaign> obtainCall() {
    return client().getApiService().campaignGet(client().getAuthId(), id);
  }
}
