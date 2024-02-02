package com.akademia.detyra2.exception.model;

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
    private Integer statusCode;
    private String message;
    private String path;
}
