package com.eustachecoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Course extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String title;
    private String description;

    //Relationship between course and author table(many courses can be written by many authors)
    @ManyToMany
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    //Relationship between course and section table(one course can have many section)
    @OneToMany(mappedBy = "course")
    private List<Section> sections;
}
