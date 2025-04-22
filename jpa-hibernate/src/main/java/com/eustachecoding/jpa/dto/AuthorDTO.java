package com.eustachecoding.jpa.dto;

import jakarta.validation.constraints.NotEmpty;

public record AuthorDTO(
       @NotEmpty(message = "Firstname should not be empty")
        String firstname,
        @NotEmpty(message = "Lastname should not be empty")
        String lastname,
        @NotEmpty(message = "The email should not be empty")
        String email,
        int age
) {
}
