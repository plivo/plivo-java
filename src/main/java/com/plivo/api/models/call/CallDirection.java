package com.plivo.api.models.call;

public enum CallDirection {
  INBOUND("inbound"), OUTBOUND("outbound");

  String direction;

  CallDirection(String direction) {
    this.direction = direction;
  }

  @Override
  public String toString() {
    return direction;
  }
}
