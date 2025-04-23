package com.eustachecoding.jpa.repositories;

import com.eustachecoding.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {
    // select * from author where age >= 60
    List<Author> findByNamedQuery(@Param("age") int id);
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
