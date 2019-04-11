package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.NodeType;

import retrofit2.Call;

public class PhloRunGetter extends Getter<PhloRunGetterResponse>{

  private final String runId;

  public PhloRunGetter(String phloId, String runID) {
    super(phloId);
    this.runId = runID;
  }

  @Override
  public PlivoClient client() {
    return this.plivoClient;
  }

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  @Override
  protected Call<PhloRunGetterResponse> obtainCall() {
    return client().getApiService().phloRunGet(this.id, this.runId);
  }

}
