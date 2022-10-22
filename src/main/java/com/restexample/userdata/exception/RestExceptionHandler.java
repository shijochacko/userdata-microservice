package com.restexample.userdata.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> invalidRequest(MethodArgumentNotValidException exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage());
        return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> invalidRequest(Exception exception){
        ApiError apiError = new ApiError(exception.getLocalizedMessage());
        return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);
    }
}
