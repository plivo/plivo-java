package com.plivo.api.models.phlo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.plivo.api.Plivo;
import com.plivo.api.PlivoClient;
import com.plivo.api.models.base.Getter;
import com.plivo.api.models.node.Node;
import com.plivo.api.models.node.NodeType;
import retrofit2.Call;

public class NodeGetter extends Getter<Node> {

  private final String phloId;
  private final NodeType nodeType;

  @JsonIgnore
  protected PlivoClient plivoClient = Plivo.getPhloClient();

  /**
   *
   * @param phloId phloId of the current flow.
   * @param nodeType node type of this node.
   * @param nodeId node id of the node.
   */
  public NodeGetter(final String phloId, final NodeType nodeType, final String nodeId) {
    super(nodeId);
    this.phloId = phloId;
    this.nodeType = nodeType;
  }

  @Override
  protected Call<Node> obtainCall() {
    return client().getApiService().nodeGet(phloId, nodeType, id);
  }
}
