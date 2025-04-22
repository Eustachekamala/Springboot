package com.eustachecoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Author extends BaseEntity {

    @Column(length = 100)
    private String firstname;
    @Column(length = 100)
    private String lastname;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 100)
    private int age;

    //Relationship between author and course table(many authers can write many courses)
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
