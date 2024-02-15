package com.akademia.detyra2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@NamedQuery(name=Post.GET_ALL ,query = "SELECT p FROM Post p")
@Entity
@Table(name = "posts")
public class Post {
    public static final String GET_ALL="get_all_posts";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "date_modified")
    private LocalDate dateModified;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
