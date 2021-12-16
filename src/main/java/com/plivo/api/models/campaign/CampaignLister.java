package com.plivo.api.models.campaign;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import com.plivo.api.util.Utils;
import retrofit2.Call;
import com.plivo.api.models.campaign.CampaignsResponse;

public class CampaignLister extends Lister<CampaignsResponse> {
  @Override
  protected Call<ListResponse<CampaignsResponse>> obtainCall() {
    return client().getApiService().campaignList(client().getAuthId(), toMap());
  }
}
