package com.plivo.api.models.message;

/**
 * Possible types of a message.
 */
public enum MessageType {
  SMS("sms"),  MMS("mms"), WHATSAPP("whatsapp");

  private final String type;

  MessageType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type;
  }
}
