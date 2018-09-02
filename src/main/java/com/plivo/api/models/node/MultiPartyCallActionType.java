package com.plivo.api.models.node;

public enum MultiPartyCallActionType {
  CALL("call"), COLD_TRANSFER("cold_transfer"), WARM_TRANSFER("warm_transfer");

  private final String action;

  MultiPartyCallActionType(final String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return this.action;
  }

}
