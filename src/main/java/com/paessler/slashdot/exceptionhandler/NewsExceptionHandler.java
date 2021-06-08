package com.paessler.slashdot.exceptionhandler;


import com.paessler.slashdot.error.ApiError;
import com.paessler.slashdot.exception.ExternalSourceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.InputMismatchException;

@RestControllerAdvice
public class NewsExceptionHandler {

    @ExceptionHandler(value = ExternalSourceException.class)
    public ResponseEntity<Object> handleExternalSourceException(ExternalSourceException ex){
        final ApiError apiError = new ApiError(ex.getStatusCode(),"External SourceException",ex.getDescription());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = InputMismatchException.class)
    public ResponseEntity<Object> handleInputMismatchException(InputMismatchException ex){
        final ApiError apiError = new ApiError(String.valueOf(HttpStatus.BAD_REQUEST.value()),ex.getClass().getSimpleName(),ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}