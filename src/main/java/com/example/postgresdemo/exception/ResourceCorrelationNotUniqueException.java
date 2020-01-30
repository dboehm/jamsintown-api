package com.example.postgresdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceCorrelationNotUniqueException extends RuntimeException {
    public ResourceCorrelationNotUniqueException(String message) {
        super(message);
    }

    public ResourceCorrelationNotUniqueException(String message, Throwable cause) {
        super(message, cause);
    }
}
