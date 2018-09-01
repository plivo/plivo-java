package com.plivo.api.models.node;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NodeMemberActionPayload {

  private NodeMemberActionType action;

  public NodeMemberActionPayload(final NodeMemberActionType action) {
    this.action = action;
  }

  public NodeMemberActionType getAction() {
    return action;
  }
}

