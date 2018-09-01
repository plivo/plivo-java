package com.plivo.api.models.phlo;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.NodeMultiPartyCall;
import com.plivo.api.models.node.NodeType;
import retrofit2.Call;

public class MultiPartyCallGetter extends Getter<NodeMultiPartyCall> {
  private final String phloId;

  public MultiPartyCallGetter(final String phloId, final String nodeId) {
    super(nodeId);
    this.phloId = phloId;
  }

  @Override
  protected Call<NodeMultiPartyCall> obtainCall() {
    return client().getPhloRestClient().getApiService()
        .multiPartyCallGet(this.phloId, NodeType.MULTI_PARTY_CALL, this.id);
  }

}
