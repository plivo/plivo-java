package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Creator;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhloRunner extends Creator<PhloRunResponse> {

  private final String phloId;
  private Map<String, String> payload = new HashMap<>();;

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  public PhloRunner(final String phloId) {
    this.phloId = phloId;
  }

  public PhloRunner(final String phloId, final Map<String, String> payload) {
    this.phloId = phloId;
    this.payload = payload;
  }

  @Override
  protected Call<PhloRunResponse> obtainCall() {
    return client().getApiService().runPhlo(this.client()
      .getAuthId(), this.phloId, this.payload);
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
