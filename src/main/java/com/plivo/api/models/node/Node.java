package com.plivo.api.models.node;

import com.plivo.api.models.base.BaseResource;

public class Node extends BaseResource {

  private String phloId;
  private String nodeId;
  private NodeType nodeType;
  private String name;
  private String createdOn;

  public Node(){}

  public String getPhloId() {
    return phloId;
  }

  public String getNodeId() {
    return nodeId;
  }

  public NodeType getNodeType() {
    return nodeType;
  }

  public String getName() {
    return name;
  }

  public String getCreatedOn() {
    return createdOn;
  }

  public NodeTriggerApiAction update(final NodeActionType nodeActionType, final NodeType nodeType,
                                     final String triggerSource, final String to, final String role) {
    return new NodeTriggerApiAction(this.phloId, nodeType, this.nodeId,
        triggerSource, to, role, nodeActionType);
  }

  @Override
  public String getId() {
    return getNodeId();
  }

}
