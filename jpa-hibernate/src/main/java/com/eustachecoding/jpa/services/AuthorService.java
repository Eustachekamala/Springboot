package com.eustachecoding.jpa.services;

import com.eustachecoding.jpa.dto.AuthorDTO;
import com.eustachecoding.jpa.dto.AuthorResponseDTO;
import com.eustachecoding.jpa.mappers.AuthorMapper;
import com.eustachecoding.jpa.models.Author;
import com.eustachecoding.jpa.repositories.AuthorRepository;
import com.eustachecoding.jpa.specification.AuthorSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    //Create author
    public AuthorResponseDTO saveAuthor(AuthorDTO authorDTO) {
        var author = authorMapper.toAuthor(authorDTO);
        var authorSaved = authorRepository.save(author);
        return authorMapper.toAuthorResponseDTO(authorSaved);
    }

    //Get All Author
    public AuthorResponseDTO findAuthorById(Integer id) {
        return authorRepository.findById(id)
                .map(authorMapper::toAuthorResponseDTO)
                .orElse(null);
    }

    //Get by interval for age less than or equal to 60
    public List<AuthorResponseDTO> findByNamedQuery(int age) {
        return authorRepository.findByNamedQuery(age)
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }

    //Get Author by Firstname
    public List<AuthorResponseDTO> findAuthorByFirstName(String firstName) {
        return authorRepository.findAllByFirstname(firstName)
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }

    //Get Author by Firstname and lastname
    public List<AuthorResponseDTO> findAuthorByFirstnameAndLastName(String firstName, String lastName) {
        return authorRepository.findByFirstnameAndLastname(firstName, lastName)
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }

    //Get All the authors
    public List<AuthorResponseDTO> findAllAuthors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }

    //Filter author by two letter
    public List<AuthorResponseDTO> findAllAuthorsByFirstNameIgnoreCase(String firstName) {
        return authorRepository.findAllByFirstnameContainingIgnoreCase(firstName)
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }

    //Update the Author
    public AuthorResponseDTO updateAuthor(Integer id, AuthorDTO authorDTO) {
        return authorRepository.findById(id)
                .map(existingAuthor -> {
                    existingAuthor.setFirstname(authorDTO.firstname());
                    existingAuthor.setLastname(authorDTO.lastname());
                    existingAuthor.setEmail(authorDTO.email());
                    existingAuthor.setAge(authorDTO.age());
                    var updatedAuthor = authorRepository.save(existingAuthor);
                    return authorMapper.toAuthorResponseDTO(updatedAuthor);
                })
                .orElse(null);
    }

    //Delete Author
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }

    //Get Author by specification values  e.g. http://localhost:8080/authors/specification?age=65&firstname=Zack
    public List<AuthorResponseDTO> findBySpecification(int age, String firstname) {
        Specification<Author> spec = Specification
                .where(AuthorSpecification.hasAge(age))
                .or(AuthorSpecification.firstNameLike(firstname));
        return authorRepository.findAll(spec)
                .stream()
                .map(authorMapper::toAuthorResponseDTO)
                .collect(Collectors.toList());
    }
}
