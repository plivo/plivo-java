package com.plivo.api.models.campaign;

import com.plivo.api.models.base.BaseResource;

public class CampaignDeleteResponse extends BaseResource{

  private String campaignId;
  private String message;

  public String getCampaignId(){
      return this.campaignId;
  }

  public String getMessage(){
      return this.message;
  }

  @Override
  public String getId(){
      return this.campaignId;
  }

}

