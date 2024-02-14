package com.detyra.mvc.exception;

public class EngineNotFoundException extends RuntimeException{
    public EngineNotFoundException(String message) {
        super(message);
    }
}
