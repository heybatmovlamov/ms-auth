package com.msauth.exception;

import java.text.MessageFormat;

public class InputMismatchException extends CommonException {
    public InputMismatchException(String message) {
        super("INPUT_MISMATCH",message);
    }

  public static InputMismatchException of(String message, Object... args) {
    return new InputMismatchException(MessageFormat.format(message, args));
  }
}
