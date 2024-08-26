package com.react.todo_list.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionInterceptor {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({TodoBadRequestException.class})
    public ResponseEntity<String> handleBadRequestUser(TodoBadRequestException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
