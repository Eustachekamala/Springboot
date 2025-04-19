package com.spring_jpa.spring_data_jpa;

public record StudentResponseDTO(
        String firstname,
        String lastname,
        String email
) {
}
