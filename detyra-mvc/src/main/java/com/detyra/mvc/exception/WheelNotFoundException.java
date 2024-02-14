package com.detyra.mvc.exception;

public class WheelNotFoundException extends RuntimeException{
    public WheelNotFoundException(String message) {
        super(message);
    }
}
