package com.spring_jpa.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    // Which service we want to test
    @InjectMocks
    private StudentService studentService;

    // Declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        // Given
        StudentDTO dto = new StudentDTO(
                "John",
                "Doe",
                "johndoe@gmail.com",
                1
        );
        Student student = new Student();
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setEmail("johndoe@gmail.com1");
        student.setAge(30);

        Student savedStudent = new Student();
        savedStudent.setFirstname("John");
        savedStudent.setLastname("Doe");
        savedStudent.setEmail("johndoe@gmail.com1");
        savedStudent.setAge(30);
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto)).thenReturn(student);
        when(repository.save(student)).thenReturn(savedStudent);
        when(studentMapper.toStudentResponseDTO(savedStudent)).thenReturn(new StudentResponseDTO(
                "John",
                "Doe",
                "johndoe@gmail.com"
        ));

        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Verify the calls
        verify(studentMapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).toStudentResponseDTO(savedStudent);

        // Then
        assertEquals(dto.firstname(), responseDTO.firstname());
        assertEquals(dto.lastname(), responseDTO.lastname());
        assertEquals(dto.email(), responseDTO.email());
    }

    @Test
    public void should_return_all_students() {
        //Given
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setFirstname("John");
        student1.setLastname("Doe");
        student1.setEmail("johndoe@gmail.com1");
        student1.setAge(30);
        students.add(student1);

        //Mock
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any())).thenReturn(new StudentResponseDTO("John", "Doe", "johndoe12@gmail.com"));

        //when
        List<StudentResponseDTO> responseDTOs = studentService.findAllStudents();

        //Then
        assertEquals(students.size(), responseDTOs.size());
        verify(repository, times(1)).findAll();
        verify(studentMapper, times(1)).toStudentResponseDTO(any());
    }

    @Test
    public void should_return_a_student_by_id() {
        Integer id = 1;
        Student student = new Student();
        student.setId(1);
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setEmail("johndoe12@gmail.com");
        student.setAge(30);

        //Mock the calls
        when(repository.findById(id)).thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDTO(any())).thenReturn(new StudentResponseDTO("John", "Doe", "johndoe12@gmail.com"));

        //When
        StudentResponseDTO responseDTO = studentService.findStudentById(id);

        //Then
        assertEquals(responseDTO.firstname(), student.getFirstname());
        assertEquals(responseDTO.lastname(), student.getLastname());
        assertEquals(responseDTO.email(), student.getEmail());

        verify(repository, times(1)).findById(id);
    }

    @Test
    public void should_return_a_student_by_name() {
        //Given
        String name = "John";
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setEmail("johndoe12@gmail.com");
        student.setAge(30);
        students.add(student);

        //Mock the call
        when(repository.findAllByFirstnameContaining(name)).thenReturn(students);
        when(studentMapper.toStudentResponseDTO(any())).thenReturn(new StudentResponseDTO("John", "Doe", "johndoe12@gmail.com"));

        //When
        var responseDTOs = studentService.findStudentByName(name);

        //Then
        assertEquals(students.size(), responseDTOs.size());
        verify(repository, times(1)).findAllByFirstnameContaining(name);
        verify(studentMapper, times(1)).toStudentResponseDTO(any());
    }

}