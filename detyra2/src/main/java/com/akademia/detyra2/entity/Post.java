package com.akademia.detyra2.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Post {
    private Integer id;
    private String title;
    private String body;
    private LocalDate dateCreated;
    private LocalDate dateModified;
    private User user;
    //private Integer userId;


}
