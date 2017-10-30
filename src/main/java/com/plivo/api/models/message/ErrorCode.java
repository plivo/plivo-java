package com.plivo.api.models.message;

public enum ErrorCode {
  INVALID_MESSAGE(10), NETWORK_ERROR(20), SPAM_DETECTED(30), INVALID_SOURCE_NUMBER(
    40), INVALID_DESTINATION_NUMBER(50),
  LOOP_DETECTED(60), DESTINATION_PERMANENTLY_UNAVAILABLE(70), DESTINATION_TEMPORARILY_UNAVAILABLE(
    80), NO_ROUTE_AVAILABLE(90),
  PROHIBITED_BY_CARRIER(100), MESSAGE_TOO_LONG(110), BLOCKED_BY_STOP(200), UNKNOWN_ERROR(1000);

  private final long errorCode;

  ErrorCode(long errorCode) {
    this.errorCode = errorCode;
  }

  public long getErrorCode() {
    return errorCode;
  }
}
