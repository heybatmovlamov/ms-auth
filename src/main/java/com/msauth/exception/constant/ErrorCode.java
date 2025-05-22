package com.msauth.exception.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorCode {

    public static final String INVALID_USER = "invalid_user";
    public static final String AUTH_ERROR = "authentication_error";
    public static final String INVALID_PASSWORD = "password_invalid";
    public static final String ALREADY_EXIST = "already_exist";
    public static final String DATA_NOT_FOUND = "data_not_found";
    public static final String OTP_EXPIRED = "otp_expired";
    public static final String RESOURCE_MISSING = "resource_missing";
    public static final String PARAMETER_INVALID = "parameter_invalid";
    public static final String REQUEST_INVALID = "request_body_invalid";
    public static final String UNEXPECTED_INTERNAL_ERROR = "unexpected_internal_error";
    public static final String INVALID_TOKEN = "token_invalid";
    public static final String COMPANY_ACCESS_FORBIDDEN = "company_access_forbidden";
}
