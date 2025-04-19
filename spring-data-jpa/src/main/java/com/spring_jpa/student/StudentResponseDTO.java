package com.spring_jpa.student;

public record StudentResponseDTO(
        String firstname,
        String lastname,
        String email
) {
}
