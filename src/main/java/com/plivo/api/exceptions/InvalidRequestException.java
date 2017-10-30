package com.plivo.api.exceptions;

public class InvalidRequestException extends PlivoRestException {
  public InvalidRequestException(String message) {
    super(message);
  }
}
