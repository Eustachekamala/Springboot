package com.spring_jpa.spring_data_jpa;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper ;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    //Create a Student
    public StudentResponseDTO saveStudent(StudentDTO studentDTO) {
        var student = studentMapper.toStudent(studentDTO);
        var sevedStudent = repository.save(student);
        return studentMapper.toStudentResponseDTO(sevedStudent);
    }

    //Get All students
    public List<StudentResponseDTO> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    //Get byID
    public StudentResponseDTO findStudentById(Integer id) {
        return repository.findById(id)
                .map(studentMapper::toStudentResponseDTO)
                .orElse(null);
    }

    //Get student by name
    public List<StudentResponseDTO> findStudentByName( String studentName ){
        return repository.findAllByFirstnameContaining(studentName)
                .stream()
                .map(studentMapper::toStudentResponseDTO)
                .collect(Collectors.toList());
    }

    //Delete Student
    public void deleteStudentById(Integer id) {
        repository.deleteById(id);
    }
}
