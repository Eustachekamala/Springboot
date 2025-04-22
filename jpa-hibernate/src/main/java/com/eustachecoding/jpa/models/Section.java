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
public class Section extends BaseEntity {
    private String name;
    private int sectionOrder;

    //Relationship between course and section table( many courses have many sections)
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    //Relationship between lecture and resource table( one section can be teach by lectures)
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
