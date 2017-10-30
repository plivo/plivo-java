package com.plivo.api.models.message;

/**
 * Possible types of a message. For now, only SMS is allowed.
 */
public enum MessageType {
  SMS("sms");

  private final String type;

  MessageType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
