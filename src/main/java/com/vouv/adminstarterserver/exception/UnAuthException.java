package com.vouv.adminstarterserver.exception;

public class UnAuthException extends RuntimeException {
    public UnAuthException() {
        super();
    }

    public UnAuthException(String message) {
        super(message);
    }

    public UnAuthException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthException(Throwable cause) {
        super(cause);
    }

    protected UnAuthException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
