package com.eustachecoding.jpa.repositories;

import com.eustachecoding.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // select * all from author
    List<Author> findAll();

    // select * from author where firstname = 'jared'
    List<Author> findAllByFirstname(String fn);

    // select * from author where firstname = 'ja'
    List<Author> findAllByFirstnameIgnoreCase(String fn);

    // select * from author where firstname like '%ja%'
    List<Author> findAllByFirstnameContainingIgnoreCase(String fn);

    // select * from author where firstname like '%ja%'
    List<Author> findAllByFirstnameStartingWithIgnoreCase(String fn);

    List<Author> findByFirstnameAndLastname(String fn, String ln);
    Optional<Author> findByEmail(String email);
    int countAllByAge(int age);
    void deleteByAge(int age);
}
