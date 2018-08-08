package com.plivo.api.models.node;

public enum MemberActionType {
  HOLD("hold"),
  UNHOLD("unhold"),
  HANGUP("hangup"),
  RESUMECALL("resumecall"),
  ABORTWARMTRANSFER("abortwarmtransfer"),
  VOICEMAILDROP("voicemaildrop");

  private final String action;

  MemberActionType(final String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return this.action;
  }
}
