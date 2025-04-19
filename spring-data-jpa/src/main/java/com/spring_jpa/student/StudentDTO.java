package com.spring_jpa.student;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
