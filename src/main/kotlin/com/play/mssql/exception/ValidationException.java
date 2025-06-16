package com.play.mssql.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final HttpStatus status;
    private final List<String> errors;

    public ValidationException(HttpStatus status, String message, List<String> errors) {
        super(message);
        this.status = status;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public List<String> getErrors() {
        return errors;
    }
}
