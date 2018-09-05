package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.NodeType;
import retrofit2.Call;

public class MultiPartyCallGetter extends Getter<MultiPartyCall> {
  private final String phloId;

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  public MultiPartyCallGetter(final String phloId, final String nodeId) {
    super(nodeId);
    this.phloId = phloId;
  }

  @Override
  protected Call<MultiPartyCall> obtainCall() {
    return client().getApiService()
        .multiPartyCallGet(this.phloId, NodeType.MULTI_PARTY_CALL, this.id);
  }

}
