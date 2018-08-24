package com.plivo.api.models.node;

public enum NodeMemberActionType {
  HOLD("hold"),
  UNHOLD("unhold"),
  HANGUP("hangup"),
  RESUMECALL("resumecall"),
  ABORTWARMTRANSFER("abortwarmtransfer"),
  VOICEMAILDROP("voicemaildrop");

  private final String action;

  NodeMemberActionType(final String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return this.action;
  }
}
