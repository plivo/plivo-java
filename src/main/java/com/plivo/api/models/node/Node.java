package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResource;

public class Node extends BaseResource {

  private String phloId;
  private String nodeId;
  private NodeType nodeType;
  private String nodeName;

  public Node(){}

  public String getPhloId() {
    return phloId;
  }

  public String getNodeId() {
    return nodeId;
  }

  public String getNodeName() {
    return nodeName;
  }

  public TriggerApiNodeAction update(final NodeActionType nodeActionType, final NodeType nodeType, final String triggerSource,
                                     final String to, final String role) {
    return new TriggerApiNodeAction(this.phloId, nodeType, this.nodeId, triggerSource, to, role, nodeActionType);
  }

  @Override
  public String getId() {
    return getNodeId();
  }

}
