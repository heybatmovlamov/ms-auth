package com.msauth.exception;

import static com.msauth.exception.constant.ErrorCode.DATA_NOT_FOUND;

import java.text.MessageFormat;

public class DataNotFoundException extends CommonException {

    public DataNotFoundException(String message) {
        super(DATA_NOT_FOUND, message);
    }

    public static DataNotFoundException of(String message, Object... args) {
        return new DataNotFoundException(MessageFormat.format(message, args));
    }
}
