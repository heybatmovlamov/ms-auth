package com.msauth.exception;

import static com.msauth.exception.constant.ErrorCode.OTP_EXPIRED;

import java.text.MessageFormat;

public class OtpExpiredException extends CommonException {
    public OtpExpiredException(String message) {
        super(OTP_EXPIRED,message);
    }

  public static OtpExpiredException of(String message, Object... args) {
    return new OtpExpiredException(MessageFormat.format(message, args));
  }
}
