package com.paessler.slashdot.exceptionhandler;

import com.paessler.slashdot.error.ApiError;
import com.paessler.slashdot.exception.ExternalSourceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class NewsExceptionHandlerTest {

    @InjectMocks
    private NewsExceptionHandler newsExceptionHandler;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleExternalSourceException() {
        ExternalSourceException externalSourceException = new ExternalSourceException(HttpStatus.INTERNAL_SERVER_ERROR.toString(),"ExternalSourceException");
        ResponseEntity<Object> responseEntity = newsExceptionHandler.handleExternalSourceException(externalSourceException);
        assertTrue(responseEntity.getBody() instanceof ApiError);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
        ApiError apiError = (ApiError) responseEntity.getBody();
        assertEquals(externalSourceException.getDescription(),apiError.getDescription());
    }

    @Test
    void handleInputMismatchException() {
        InputMismatchException inputMismatchException = new InputMismatchException(String.format("Please enter a valid year %s","2014"));
        ResponseEntity<Object> responseEntity = newsExceptionHandler.handleInputMismatchException(inputMismatchException);
        assertTrue(responseEntity.getBody() instanceof ApiError);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
        ApiError apiError = (ApiError) responseEntity.getBody();
        assertEquals(inputMismatchException.getMessage(),apiError.getDescription());
    }
}