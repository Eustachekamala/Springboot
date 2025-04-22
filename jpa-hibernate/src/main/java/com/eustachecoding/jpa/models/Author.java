package com.eustachecoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(length = 100)
    private String firstname;
    @Column(length = 100)
    private String lastname;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private int age;
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @Column(insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
