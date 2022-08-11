package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class CampaignNumbersGetter extends Getter<Campaign> {

  private String id;
  private Integer limit;
  private Integer offset;

  public CampaignNumbersGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Campaign> obtainCall() {
    return client().getApiService().campaignNumbersGet(client().getAuthId(), id, limit, offset);
  }
}