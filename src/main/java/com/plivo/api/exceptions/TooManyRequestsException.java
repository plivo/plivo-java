package com.plivo.api.exceptions;

public class TooManyRequestsException extends PlivoRestException {
  public TooManyRequestsException(String message) {
    super(message);
  }
}
