package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class CampaignNumberGetter extends Getter<Campaign> {

  private String id;
  private String number;

  public CampaignNumberGetter(String id) {
    super(id);
  }

  public CampaignNumberGetter number(String number) {
    this.number = number;
    return this;
  }

  @Override
  protected Call<Campaign> obtainCall() {
    return client().getApiService().campaignNumberGet(client().getAuthId(), id, number);
  }
}