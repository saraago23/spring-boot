package com.akademia.exercise1.entity;

import lombok.*;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {

    private Integer id;
    private String authorName;
    private LocalDate birthDate;
}
