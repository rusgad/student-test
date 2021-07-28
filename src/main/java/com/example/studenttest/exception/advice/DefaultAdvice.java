package com.example.studenttest.exception.advice;

import com.example.studenttest.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleException(UserNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>("Validation error: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
