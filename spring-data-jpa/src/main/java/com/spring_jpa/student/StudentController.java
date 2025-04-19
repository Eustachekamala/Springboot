package com.spring_jpa.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(
            @RequestBody StudentDTO studentDTO
    ) {
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/student/{id}")
    public StudentResponseDTO findStudentById(
            @PathVariable("id") Integer id
    ){
        return studentService.findStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDTO> findStudentByName(
            @PathVariable("student-name") String studentName
    ){
        return studentService.findStudentByName(studentName);
    }

    @DeleteMapping("/student/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id
    ) {
        studentService.deleteStudentById(id);
    }
}
