package com.example.postgresdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExistentException extends RuntimeException {
    public ResourceAlreadyExistentException(String message) {
        super(message);
    }

    public ResourceAlreadyExistentException(String message, Throwable cause) {
        super(message, cause);
    }
}
