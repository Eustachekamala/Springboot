package com.eustachecoding.jpa.services;

import com.eustachecoding.jpa.dto.CourseDTO;
import com.eustachecoding.jpa.dto.CourseResponseDTO;
import com.eustachecoding.jpa.mappers.CourseMapper;
import com.eustachecoding.jpa.models.Course;
import com.eustachecoding.jpa.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<CourseResponseDTO> findByTitle(String title) {
        return courseRepository.findCourseByTitle(title)
                .stream()
                .map(courseMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CourseResponseDTO saveCourse(CourseDTO courseDTO) {
        var course = courseMapper.toDto(courseDTO);
        var courseSaved = courseRepository.save(course);
        return courseMapper.toResponseDTO(courseSaved);
    }

    public Course updateCourse(Integer id, Course course) {
        return courseRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(course.getTitle());
                    existing.setDescription(course.getDescription());
                    return courseRepository.save(existing);
                })
                .orElse(null);
    }
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
