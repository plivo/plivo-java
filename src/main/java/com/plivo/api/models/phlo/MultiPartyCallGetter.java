package com.plivo.api.models.phlo;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.MultiPartyCall;
import com.plivo.api.models.node.NodeType;
import retrofit2.Call;

public class MultiPartyCallGetter extends Getter<MultiPartyCall> {
  private final String phloId;

  public MultiPartyCallGetter(final String phloId, final String nodeId) {
    super(nodeId);
    this.phloId = phloId;
  }

  @Override
  protected Call<MultiPartyCall> obtainCall() {
    return client().getPhloRestClient().getApiService().multiPartyCallGet(this.phloId, NodeType.MULTIPARTYCALL, this.id);
  }

}
