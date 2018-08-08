package com.plivo.api.models.phlo;

import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.Node;
import com.plivo.api.models.node.NodeType;
import retrofit2.Call;

public class NodeGetter extends Getter<Node> {

  private final String phloId;
  private final NodeType nodeType;

  public NodeGetter(final String phloId, final NodeType nodeType, final String nodeId) {
    super(nodeId);
    this.phloId = phloId;
    this.nodeType = nodeType;
  }

  @Override
  protected Call<Node> obtainCall() {
    return client().getPhloRestClient().getApiService().nodeGet(phloId, nodeType, id);
  }
}
