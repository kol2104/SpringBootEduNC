package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAdvice {

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity handleException(UserNotFoundException exception) {
        Object errorBody = exception.getMessage();
        return new ResponseEntity(errorBody, HttpStatus.NOT_FOUND);
    }

}
