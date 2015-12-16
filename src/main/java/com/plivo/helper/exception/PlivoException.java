package com.plivo.helper.exception;

public class PlivoException extends Exception {
    public PlivoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlivoException(String message) {
        super(message);
    }

    public PlivoException(Throwable cause) {
        super(cause);
    }

}