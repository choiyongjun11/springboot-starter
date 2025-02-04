package com.springboot.advice;


import com.springboot.exception.BusinessLogicException;
import com.springboot.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        final ErrorResponse response = ErrorResponse.of(e.getBindingResult());

        return response;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(
            ConstraintViolationException e) {
        final ErrorResponse response = ErrorResponse.of(e.getConstraintViolations());

        return response;
    }

//    @ExceptionHandler
//    public ResponseEntity handleBusinessLogicException(BusinessLogicException e) {
//        int status = e.getExceptionCode().getStatus();
//        String message = e.getMessage();
//
//        // TODO GlobalExceptionAdvice 기능 추가 1
//        return new ResponseEntity<>(ErrorResponse.of(status, message), HttpStatus.valueOf(e.getExceptionCode()
//                .getStatus()));
//    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleBusinessLogicException(BusinessLogicException e) {
        int status = e.getExceptionCode().getStatus();
        String message = e.getMessage();

        // TODO GlobalExceptionAdvice 기능 추가 1
        return ErrorResponse.of(status, message);
    }

    // TODO GlobalExceptionAdvice 기능 추가 2

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        int status = HttpStatus.METHOD_NOT_ALLOWED.value();
        String message = HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase();
        return ErrorResponse.of(status, message);
    }

    // TODO GlobalExceptionAdvice 기능 추가 3

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(NullPointerException e) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        return ErrorResponse.of(status, message);
    }
}

