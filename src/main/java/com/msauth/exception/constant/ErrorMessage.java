package com.msauth.exception.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessage {

  public static final String EMAIL_OR_PASSWORD_IS_INCORRECT = "Email or password is incorrect";
  public static final String OTP_IS_EXPIRED_OR_NOT_FOUND = "OTP is expired or not found";
  public static final String OTP_DOES_NOT_MATCH = "OTP does not match";
  public static final String USER_NOT_FOUND = "User not found";
}