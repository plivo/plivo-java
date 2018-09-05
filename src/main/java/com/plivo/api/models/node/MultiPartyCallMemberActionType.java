package com.plivo.api.models.node;

public enum MultiPartyCallMemberActionType {
  HOLD("hold"),
  UNHOLD("unhold"),
  HANGUP("hangup"),
  RESUME_CALL("resume_call"),
  ABORT_TRANSFER("abort_transfer"),
  VOICEMAIL_DROP("voicemail_drop");

  private final String action;

  MultiPartyCallMemberActionType(final String action) {
    this.action = action;
  }

  public String getAction() {
    return action;
  }

  @Override
  public String toString() {
    return this.action;
  }
}
