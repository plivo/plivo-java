package com.plivo.api.models.node;

public class NodeMemberActionPayload {

  private NodeMemberActionType action;

  public NodeMemberActionPayload(final NodeMemberActionType action) {
    this.action = action;
  }

  public NodeMemberActionType getAction() {
    return action;
  }
}

