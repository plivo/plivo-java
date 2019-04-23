package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Client;
import com.plivo.api.Plivo;
import com.plivo.api.models.base.Getter;
import com.plivo.api.models.phlo.PhloGetter;

import retrofit2.Call;

public class MultiPartyCallGetter extends Getter<MultiPartyCall> {

  private final String phloId;

  public MultiPartyCallGetter(String phloId, String id) {
    super(id);
    this.phloId = phloId;
  }

  @Override
  public Client client() {
    return this.plivoClient;
  }
  
  @Override
  public MultiPartyCallGetter client(final Client plivoClient) {
	super.client(plivoClient);
    this.plivoClient = plivoClient;
    return this;
  }

  @JsonIgnore
  protected Client plivoClient = Plivo.getPhloClient();

  @Override
  protected Call<MultiPartyCall> obtainCall() {
    return client().getApiService()
      .multiPartyCallGet(this.phloId, NodeType.MULTI_PARTY_CALL, this.id);
  }
}
