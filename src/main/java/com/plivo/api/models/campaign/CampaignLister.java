package com.plivo.api.models.campaign;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;

public class CampaignLister extends Lister<CampaignResponse> {


  @Override
  protected Call<ListResponse<CampaignResponse>> obtainCall() {
    return client().getApiService().campaignList(client().getAuthId(), toMap());
  }
}