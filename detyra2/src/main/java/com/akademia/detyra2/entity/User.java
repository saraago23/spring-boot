package com.akademia.detyra2.entity;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
