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
    public Student post(
            @RequestBody Student student
    ) {
        return repository.save(student);
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
