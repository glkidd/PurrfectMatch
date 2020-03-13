package com.purrfectmatch.restservice;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}