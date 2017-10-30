package com.plivo.api.models.message;

public enum MessageDirection {
  INBOUND("inbound"), OUTBOUND("outbound");

  private String direction;

  MessageDirection(String direction) {
    this.direction = direction;
  }

  @Override
  public String toString() {
    return this.direction;
  }
}
