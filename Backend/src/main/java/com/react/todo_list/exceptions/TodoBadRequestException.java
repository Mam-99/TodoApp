package com.react.todo_list.exceptions;

public class TodoBadRequestException extends RuntimeException{
    public TodoBadRequestException(String message) {
        super(message);
    }
}
