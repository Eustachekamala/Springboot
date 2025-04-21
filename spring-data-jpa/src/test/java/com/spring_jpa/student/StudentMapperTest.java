package com.spring_jpa.student;

import org.junit.jupiter.api.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDTOToStudent() {
       StudentDTO dto = new StudentDTO(
               "John",
               "Doe",
               "johndoe@gmail.com",
               1
       );

       Student student = mapper.toStudent(dto);


       Assertions.assertEquals(dto.firstname(), student.getFirstname());
       Assertions.assertEquals(dto.lastname(), student.getLastname());
       Assertions.assertEquals(dto.email(), student.getEmail());
       Assertions.assertNotNull(student.getSchool());
       Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());

    }

    @Test
    public void shouldMapStudentToStudentResponseDTO(){
        //Given
        Student student = new Student();
        student.setFirstname("John");
        student.setLastname("Doe");
        student.setEmail("johndoe@gmail.com");
        student.setId(1);
        student.setAge(25);

        //When
        StudentResponseDTO responseDTO = mapper.toStudentResponseDTO(student);

        //Then
        Assertions.assertEquals(responseDTO.firstname(), student.getFirstname());
        Assertions.assertEquals(responseDTO.lastname(), student.getLastname());
        Assertions.assertEquals(responseDTO.email(), student.getEmail());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDTO_is_null(){
      var exp = Assertions.assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
      Assertions.assertEquals( "The student DTO should not be null", exp.getMessage());
    }
}