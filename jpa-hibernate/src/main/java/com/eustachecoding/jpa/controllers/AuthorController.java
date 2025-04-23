package com.eustachecoding.jpa.controllers;

import com.eustachecoding.jpa.dto.AuthorDTO;
import com.eustachecoding.jpa.dto.AuthorResponseDTO;
import com.eustachecoding.jpa.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    //Get Author by specification values  e.g. http://localhost:8080/authors/specification?age=65&firstname=Zack
    @GetMapping("/authors/specification")
    public List<AuthorResponseDTO> findAuthorsBySpecification(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String firstname
    ){
       return authorService.findBySpecification(age, firstname);
    }

    @GetMapping("/authors/search/age/{age}")
    public List<AuthorResponseDTO> findByNamedQuery(
            @PathVariable Integer age
    ){
        return authorService.findByNamedQuery(age);
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

    /*
     * Handles exceptions of type MethodArgumentNotValidException that occur when
     * validation on a method argument annotated with @Valid fails.
     *
     * @param exp the MethodArgumentNotValidException containing details about the validation errors
     * @return a ResponseEntity containing a map of field names and their corresponding error messages,
     *         along with a BAD_REQUEST (400) HTTP status
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exp){
        //Create a map to store field names and their corresponding error message
        var errors = new HashMap<String,String>();

        //Iterate through all validation errors and populate the map
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField(); // Extract the field name
            var errorMessage = error.getDefaultMessage(); // Extract the error message
            errors.put(fieldName, errorMessage);
        });

        /// Return the map of errors wrapped in a ResponseEntity with a BAD_REQUEST status
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
