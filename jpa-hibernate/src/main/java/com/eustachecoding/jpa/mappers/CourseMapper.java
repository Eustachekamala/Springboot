package com.eustachecoding.jpa.mappers;

import com.eustachecoding.jpa.dto.CourseDTO;
import com.eustachecoding.jpa.dto.CourseResponseDTO;
import com.eustachecoding.jpa.models.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public Course toDto(CourseDTO courseDTO) {
        if (courseDTO == null) {
            throw new NullPointerException("course should not be null");
        }
        var course = new Course();
        course.setTitle(courseDTO.title());
        course.setDescription(courseDTO.description());
        return course;
    }

    public CourseResponseDTO toResponseDTO(Course course) {
        return new CourseResponseDTO(course.getTitle(), course.getDescription());
    }
}
