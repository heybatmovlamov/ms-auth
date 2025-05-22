package com.msauth.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.msauth.exception.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@Component
@RequiredArgsConstructor
@RestControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AlreadyExistException.class})
    public ErrorResponse handleAlreadyExistException(AlreadyExistException ex) {
        this.addErrorLog(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getMessage(), "AlreadyExistException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({BadCredentialsException.class})
    public ErrorResponse handleBadCredentialsException(BadCredentialsException ex) {
        this.addErrorLog(HttpStatus.UNAUTHORIZED, ex.getErrorCode(), ex.getMessage(), "BadCredentialsException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorResponse handleDataNotFoundException(DataNotFoundException ex) {
        addErrorLog(NOT_FOUND, ex.getErrorCode(), ex.getMessage(), "DataNotFoundException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(InputMismatchException.class)
    public ErrorResponse handleInputMismatchException(InputMismatchException ex) {
        addErrorLog(BAD_REQUEST, ex.getErrorCode(), ex.getMessage(), "InputMismatchException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(OtpExpiredException.class)
    public ErrorResponse handleInputMismatchException(OtpExpiredException ex) {
        addErrorLog(NOT_FOUND, ex.getErrorCode(), ex.getMessage(), "OtpExpiredException");
        return new ErrorResponse(ex.getErrorCode(), ex.getMessage());
    }

    protected void addErrorLog(HttpStatus httpStatus, String errorCode, String errorMessage, String exceptionType) {
        log.error("HttpStatus: {} | Code: {} | Type: {} | Message: {}", httpStatus, errorCode,
                exceptionType, errorMessage);
    }

}
