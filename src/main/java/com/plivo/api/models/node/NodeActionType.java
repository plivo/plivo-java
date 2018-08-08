package com.plivo.api.models.node;

public enum NodeActionType {
  CALL("call"), COLDTRANSFER("coldtransfer"), WARMTRANSFER("warmtransfer");

  private final String action;

  NodeActionType(final String action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return this.action;
  }

}
