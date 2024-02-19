package com.plivo.api.models.campaign;

import com.plivo.api.models.base.Importer;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignImporter extends Importer<CampaignImportResponse> {
  private String campaignID;
  private String campaignAlias;
  
  CampaignImporter(String campaignID,String campaignAlias) {
   
    this.campaignID = campaignID;
    this.campaignAlias = campaignAlias;
  }

  public String campaignID(){
      return this.campaignID;
  }

  public String campaignAlias(){
      return this.campaignAlias;
  }



  @Override
  protected Call<CampaignImportResponse> obtainCall() {
    return client().getApiService().importCampaign(client().getAuthId(), this);
  }
}