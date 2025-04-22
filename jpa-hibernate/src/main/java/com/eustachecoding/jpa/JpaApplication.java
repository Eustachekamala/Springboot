package com.eustachecoding.jpa;

import com.eustachecoding.jpa.models.Author;
import com.eustachecoding.jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
		return args -> {
			var author = Author.builder()
					.firstname("John")
					.lastname("Smith")
					.email("johnsmith@gmail.com")
					.age(43)
					.build();
			repository.save(author);
		};
	}

}