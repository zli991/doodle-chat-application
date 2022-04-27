package com.doodle.sanitization.exception;

public class SanitizationException extends RuntimeException {
    private static final long serialVersionUID = -4249115446104870365L;

    public SanitizationException(final String message) {
        super(message);
    }
}
