package com.akademia.detyra2.entity;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Category {
    private Integer id;
    private String name;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
