package com.akademia.detyra2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@NamedQuery(name=Category.GET_ALL,query = "SELECT c FROM Category c")
@Entity
@Table(name="categories")
public class Category {
    public static final String GET_ALL="get_all_categories";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="date_created")
    private LocalDate dateCreated;
    @Column(name="date_modified")
    private LocalDate dateModified;
}
