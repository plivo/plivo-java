package com.plivo.api.models.endpoint;

import com.plivo.api.models.base.Getter;
import retrofit2.Call;

public class EndpointGetter extends Getter<Endpoint> {

  public EndpointGetter(String id) {
    super(id);
  }

  @Override
  protected Call<Endpoint> obtainCall() {
    return client().getPlivoRestClient().getApiService().endpointGet(client().getPlivoRestClient().getAuthId(), id);
  }
}
