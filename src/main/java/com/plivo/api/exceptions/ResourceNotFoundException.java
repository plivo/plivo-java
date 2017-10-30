package com.plivo.api.exceptions;

public class ResourceNotFoundException extends PlivoRestException {
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
