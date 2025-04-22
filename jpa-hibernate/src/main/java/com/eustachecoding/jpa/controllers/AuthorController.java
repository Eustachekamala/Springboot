package com.eustachecoding.jpa.controllers;

import com.eustachecoding.jpa.dto.AuthorDTO;
import com.eustachecoding.jpa.dto.AuthorResponseDTO;
import com.eustachecoding.jpa.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDTO addAuthor(
            @Valid  @RequestBody AuthorDTO authorDTO) {
        return authorService.saveAuthor(authorDTO);
    }

    @GetMapping("/authors")
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public AuthorResponseDTO getAuthorById(
            @PathVariable Integer id
    ){
        return authorService.findAuthorById(id);
    }

    @GetMapping("/authors/search/{firstname}")
    public List<AuthorResponseDTO> getAuthorByFirstName(
            @PathVariable String firstname
    ){
        return authorService.findAuthorByFirstName(firstname);
    }

    @GetMapping("/authors/filter/{twoLatter}")
    public List<AuthorResponseDTO> findAuthorByFirstNameIgnoreCase(
            @PathVariable String twoLatter
    ){
        return  authorService.findAllAuthorsByFirstNameIgnoreCase(twoLatter);
    }

    @PatchMapping("/authors/update/{id}")
    public AuthorResponseDTO updateAuthor(
            @PathVariable Integer id, @Valid @RequestBody AuthorDTO authorDTO
    ){
        return authorService.updateAuthor(id, authorDTO);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
    }
}
