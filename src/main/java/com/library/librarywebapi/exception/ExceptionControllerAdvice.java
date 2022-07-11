package com.library.librarywebapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

public class ExceptionControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException exception) {
        String message = exception.getMessage() == null ? "Resource" : exception.getMessage();
        return new ResponseEntity<>(message + " not found!", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> entityExistsException(EntityExistsException e) {
        String message = String.format("%s already exist.", e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
