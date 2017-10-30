package com.plivo.api.models.message;

/**
 * Possible states a message can be in.
 */
public enum MessageState {
  QUEUED("queued"), SENT("sent"), FAILED("failed"), DELIVERED("delivered"), UNDELIVERED(
    "undelivered"), REJECTED("rejected");

  private String state;

  MessageState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return state;
  }
}
