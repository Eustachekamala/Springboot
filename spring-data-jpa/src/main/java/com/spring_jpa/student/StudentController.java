package com.spring_jpa.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(
            @Valid @RequestBody StudentDTO studentDTO
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

    /**
     * Handles exceptions of type MethodArgumentNotValidException that occur when
     * validation on a method argument annotated with @Valid fails.
     *
     * @param exp the MethodArgumentNotValidException containing details about the validation errors
     * @return a ResponseEntity containing a map of field names and their corresponding error messages,
     *         along with a BAD_REQUEST (400) HTTP status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp) {
        // Create a map to store field names and their corresponding error messages
        var errors = new HashMap<String, String>();

        // Iterate through all validation errors and populate the map
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField(); // Extract the field name
            var errorMessage = error.getDefaultMessage();    // Extract the error message
            errors.put(fieldName, errorMessage);             // Add the field name and error message to the map
        });

        // Return the map of errors wrapped in a ResponseEntity with a BAD_REQUEST status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
