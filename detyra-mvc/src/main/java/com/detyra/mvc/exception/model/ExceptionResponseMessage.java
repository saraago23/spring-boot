package com.detyra.mvc.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseMessage {

    private LocalDateTime timestamp;
    private String message;
    private Integer statusCode;
    private String path;
}
