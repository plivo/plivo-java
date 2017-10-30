package com.plivo.api.exceptions;

public class PlivoRestException extends Exception {

  public PlivoRestException() {
    super();
  }

  public PlivoRestException(String err) {
    super(err);
  }
}
