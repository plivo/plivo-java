package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignsResponse extends BaseResponse {

  List<CampaignResponse> campaigns;

  public List<CampaignResponse> getCampaigns() {
    return campaigns;
  }
}