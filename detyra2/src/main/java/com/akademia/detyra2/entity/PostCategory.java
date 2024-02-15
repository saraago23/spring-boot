package com.akademia.detyra2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@NamedQuery(name=PostCategory.GET_ALL,query = "SELECT pc FROM PostCategory pc")
@Entity
@Table(name="post_categories")
public class PostCategory {
    public static final String GET_ALL="get_all_post_categories";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "post_id",referencedColumnName = "id")
    private Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @Column(name="date_created")
    private LocalDate dateCreated;
    @Column(name="date_modified")
    private LocalDate dateModified;

}
