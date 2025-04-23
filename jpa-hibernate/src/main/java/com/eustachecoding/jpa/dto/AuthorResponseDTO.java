package com.eustachecoding.jpa.dto;

public record AuthorResponseDTO(
        String firstname,
        String lastname,
        String email,
        int age
) {
}
