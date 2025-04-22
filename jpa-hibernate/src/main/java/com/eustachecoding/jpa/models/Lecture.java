package com.eustachecoding.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {
    private String name;

    //Relationship between section and lecture table(many lectures can teach one section)
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    //Relationship between lecture and resource table( one resource can be used by one lecture)
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
