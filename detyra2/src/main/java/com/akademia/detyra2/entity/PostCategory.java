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

public class PostCategory {
    private Integer id;
    private Post post;
    private Category category;
    private LocalDate dateCreated;
    private LocalDate dateModified;

}
