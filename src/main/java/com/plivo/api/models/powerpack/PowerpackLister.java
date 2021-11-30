package com.plivo.api.models.powerpack;

import java.io.IOException;
import com.plivo.api.exceptions.PlivoRestException;

import com.plivo.api.models.base.ListResponse;
import com.plivo.api.models.base.Lister;
import retrofit2.Call;
import retrofit2.Response;

public class PowerpackLister extends Lister<Powerpack> {

  public Long get() throws IOException, PlivoRestException {
    validate();
    Response<ListResponse<Powerpack>> response = obtainCall().execute();
    handleResponse(response);
    try {
      return response.body().getMeta().getTotalCount();
    } catch (Exception e) {
      return 0L;
    }
  }

  @Override
  protected Call<ListResponse<Powerpack>> obtainCall() {
    return client().getApiService().powerpackList(client().getAuthId(), toMap());
  }
}
