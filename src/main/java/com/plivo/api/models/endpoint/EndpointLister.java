package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;

public class EndpointLister extends Lister<Endpoint> {

  @Override
  protected Call<ListResponse<Endpoint>> obtainCall() {
    return client().getApiService().endpointList(client().getAuthId(), toMap());
  }
}
