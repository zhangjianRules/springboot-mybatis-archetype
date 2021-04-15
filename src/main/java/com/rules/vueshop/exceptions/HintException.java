package com.rules.vueshop.exceptions;

public class HintException extends RuntimeException {
    public HintException() {}

    public HintException(String message) {
        super(message);
    }

    public HintException(String message, Throwable cause) {
        super(message, cause);
    }

    public HintException(Throwable cause) {
        super(cause);
    }

    public HintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
