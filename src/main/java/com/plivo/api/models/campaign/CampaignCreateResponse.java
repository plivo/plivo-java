package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResponse;
import java.util.List;

public class CampaignCreateResponse extends BaseResponse {

  private CampaignResponse campaign;

  public CampaignResponse campaign() {
    return campaign;
  }
}