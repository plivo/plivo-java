package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class CampaignNumbersGetter extends Getter<Number> {

  private String id;
  private Integer limit;
  private Integer offset;

  public CampaignNumbersGetter(String id) {
    super(id);
  }

  public CampaignNumbersGetter limitAndOffset(Integer limit, Integer offset) {
    this.limit = limit;
    this.offset = offset;
    return this;
  }

  @Override
  protected Call<Number> obtainCall() {
    return client().getApiService().campaignNumbersGet(client().getAuthId(), id, limit, offset);
  }
}