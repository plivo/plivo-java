package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class CampaignNumberGetter extends Getter<CampaignNumbers> {

  private String campaignID;
  private String number;

  public CampaignNumberGetter(String campaignID) {
    super(campaignID);
    this.campaignID = campaignID;
  }

  public CampaignNumberGetter number(String number) {
    this.number = number;
    return this;
  }

  @Override
  protected Call<CampaignNumbers> obtainCall() {
    return client().getApiService().campaignNumberGet(client().getAuthId(), campaignID, number);
  }
}