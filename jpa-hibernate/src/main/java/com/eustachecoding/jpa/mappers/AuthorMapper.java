package com.eustachecoding.jpa.mappers;

import com.eustachecoding.jpa.dto.AuthorDTO;
import com.eustachecoding.jpa.dto.AuthorResponseDTO;
import com.eustachecoding.jpa.models.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {

    //convert a AuthorDTO object to a Author entity
    public Author toAuthor(AuthorDTO dto){
        if(dto == null) {
            throw new NullPointerException("The Author DTO should not be  null");
        }

        var author = new Author();
        author.setFirstname(dto.firstname());
        author.setLastname(dto.lastname());
        author.setEmail(dto.email());
        return author;
    }

    //Convert Author entity to AuthorResponseDTO
    public AuthorResponseDTO toAuthorResponseDTO(Author author){
        return new AuthorResponseDTO(author.getFirstname(), author.getLastname(), author.getEmail());
    }
}
