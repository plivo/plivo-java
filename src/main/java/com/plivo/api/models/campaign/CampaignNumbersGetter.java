package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;

import retrofit2.Call;

public class CampaignNumbersGetter extends Getter<CampaignNumbers> {

  private String campaignID;
  private Integer limit;
  private Integer offset;

  public CampaignNumbersGetter(String campaignID) {
    super(campaignID);
    this.campaignID = campaignID;

  }

  public CampaignNumbersGetter limit(Integer limit) {
    this.limit = limit;
    return this;

  }

  public CampaignNumbersGetter offset(Integer offset) {
    this.offset = offset;
    return this;

  }

  @Override
  protected Call<CampaignNumbers> obtainCall() {
    return client().getApiService().campaignNumbersGet(client().getAuthId(), campaignID, limit, offset);
  }
}