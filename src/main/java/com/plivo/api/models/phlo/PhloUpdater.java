package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParseException;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.exceptions.PlivoRestException;
import com.plivo.api.models.base.Updater;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhloUpdater extends Updater<PhloUpdateResponse> {

  private Map<String, Object> payload = new HashMap<>();

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  public PhloUpdater(final String phloId) {
    super(phloId);
  }

  public PhloUpdater payload(Map<String, Object> payload) {
    this.payload = payload;
    return this;
  }

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  public PhloUpdateResponse run() throws IOException, PlivoRestException {
    validate();

    try {
      Response<PhloUpdateResponse> response = obtainCall().execute();
      handleResponse(response);
      return response.body();
    } catch (JsonParseException je) {
      //FIXME( server side needs to be updated to return proper json )
      System.out.println("Improperly formed json received as response, ignoring!!");
    }
    return null;

  }

  @Override
  protected Call<PhloUpdateResponse> obtainCall() {
    return client().getApiService().runPhlo(this.client()
      .getAuthId(), id, this.payload);
  }
}
