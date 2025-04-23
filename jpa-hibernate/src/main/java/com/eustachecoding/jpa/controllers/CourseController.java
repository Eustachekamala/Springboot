package com.eustachecoding.jpa.controllers;

import com.eustachecoding.jpa.dto.CourseDTO;
import com.eustachecoding.jpa.dto.CourseResponseDTO;
import com.eustachecoding.jpa.models.Course;
import com.eustachecoding.jpa.services.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/courses")
    public CourseResponseDTO addCourse(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.saveCourse(courseDTO);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(
            @PathVariable Integer id) {
        return courseService.findById(id);
    }

    @GetMapping("/courses/search/{title}")
    public List<CourseResponseDTO> getCourseByTitle(
            @PathVariable String title
    ) {
        return courseService.findByTitle(title);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourseById(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }

    @PatchMapping("/courses/update/{id}")
    public Course updateCourse(@PathVariable Integer id) {
        return courseService.updateCourse(id, courseService.findById(id));
    }
}
