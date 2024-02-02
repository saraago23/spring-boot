package com.akademia.detyra2.controller.advice;

import com.akademia.detyra2.exception.CategoryNotFoundException;
import com.akademia.detyra2.exception.PostNotFoundException;
import com.akademia.detyra2.exception.UserNotFoundException;
import com.akademia.detyra2.exception.model.ExceptionResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalControllerExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponseMessage> blogExceptionHandler(
            Exception ex, HttpServletRequest req) {

        var errorObject = ExceptionResponseMessage.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .path(req.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
        return ResponseEntity.ok(errorObject);
    }

}
