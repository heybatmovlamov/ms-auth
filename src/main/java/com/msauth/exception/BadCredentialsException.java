package com.msauth.exception;

import java.text.MessageFormat;

public class BadCredentialsException extends CommonException {
    public BadCredentialsException(String message) {
        super("AUTH_FAILED",message);
    }

    public static BadCredentialsException of(String message, Object... args) {
        return new BadCredentialsException(MessageFormat.format(message, args));
    }
}
