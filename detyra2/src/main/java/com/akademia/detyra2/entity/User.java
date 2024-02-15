package com.akademia.detyra2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u")

@Entity
@Table(name = "users")
public class User {
    public static final String GET_ALL = "get_all_users";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "date_modified")
    private LocalDate dateModified;
}
