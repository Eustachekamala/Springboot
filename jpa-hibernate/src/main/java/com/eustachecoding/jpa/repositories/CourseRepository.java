package com.eustachecoding.jpa.repositories;

import com.eustachecoding.jpa.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List <Course> findCourseByTitle(String title);
    void deleteCourseById(Integer id);
}
