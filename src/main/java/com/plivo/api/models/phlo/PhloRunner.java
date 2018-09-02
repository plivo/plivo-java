package com.plivo.api.models.phlo;

import com.fasterxml.jackson.core.JsonParseException;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

import java.io.IOException;

public class PhloRunner extends Creator<PhloRunResponse> {

  private final String phloId;

  public PhloRunner(final String phloId) {
    this.phloId = phloId;
  }

  @Override
  protected Call<PhloRunResponse> obtainCall() {
    return client().getPhloRestClient().getApiService().runPhlo(this.client()
      .getPhloRestClient().getAuthId(), this.phloId);
  }

  public PhloRunResponse run() throws IOException, PlivoRestException {
    try {
      return create();
    } catch (JsonParseException je) {
      //FIXME( server side needs to be updated to return proper json )
      System.out.println("Improperly formed json recieved as response, ignoring!!");
    }

    return null;
  }
}
