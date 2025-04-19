package com.spring_jpa.spring_data_jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
   private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/students")
    public StudentResponseDTO post(
            @RequestBody StudentDTO studentDTO
    ) {
        var student = toStudent(studentDTO);
        var sevedStudent = repository.save(student);
        return toStudentResponseDTO(sevedStudent);
    }

    /**
     * Converts a StudentDTO object to a Student entity.
     *
     * @param dto the StudentDTO object containing the data to be transformed
     * @return a Student entity populated with the data from the provided StudentDTO
     */
    private Student toStudent(StudentDTO dto) {
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
    private StudentResponseDTO toStudentResponseDTO(Student student) {
        return new StudentResponseDTO(student.getFirstname(), student.getLastname(), student.getEmail());
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student findStudentById(
            @PathVariable("id") Integer id
    ){
        return repository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String studentName
    ){
        return repository.findAllByFirstnameContaining(studentName);
    }


    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable Integer id
    ) {
        repository.deleteById(id);
    }
}
