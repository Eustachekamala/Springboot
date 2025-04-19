package com.spring_jpa.spring_data_jpa;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
