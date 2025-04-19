package com.spring_jpa.student;

import com.spring_jpa.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    /**
     * Converts a StudentDTO object to a Student entity.
     *
     * @param dto the StudentDTO object containing the data to be transformed
     * @return a Student entity populated with the data from the provided StudentDTO
     */
    public Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    /**
     * Converts a Student entity to a StudentResponseDTO.
     *
     * @param student the Student entity to be converted
     * @return a StudentResponseDTO containing the first name, last name, and email of the student
     */
    public StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(student.getFirstname(), student.getLastname(), student.getEmail());
    }
}
