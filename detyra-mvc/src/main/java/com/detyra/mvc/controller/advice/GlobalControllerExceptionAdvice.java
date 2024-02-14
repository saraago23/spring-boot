package com.detyra.mvc.controller.advice;


import com.detyra.mvc.exception.CarNotFoundException;
import com.detyra.mvc.exception.EngineNotFoundException;
import com.detyra.mvc.exception.WheelNotFoundException;
import com.detyra.mvc.exception.model.ExceptionResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalControllerExceptionAdvice {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handleCarNotFoundException(
            CarNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handleEngineNotFoundException(
            EngineNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> handleWheelNotFoundException(
            WheelNotFoundException ex, HttpServletRequest req){
        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }

}
