package com.plivo.api.models.node;

public class MemberActionPayload {

  private MemberActionType action;

  public MemberActionPayload(final MemberActionType action){
    this.action = action;
  }

  public MemberActionType getAction() {
    return action;
  }
}

