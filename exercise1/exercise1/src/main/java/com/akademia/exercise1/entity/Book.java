package com.akademia.exercise1.entity;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private Integer id;
    private String title;
    private Author author;
    private LocalDate publicationYear;
}
