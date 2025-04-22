package com.eustachecoding.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "resource_type") --> only with SINGLE_Tab
public class Resource {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    @Column(unique = true)
    private String url;

    //Relationship between lecture and resource table( one lecture can use one resource)
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
