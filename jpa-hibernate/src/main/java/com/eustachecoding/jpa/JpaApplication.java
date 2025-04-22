package com.eustachecoding.jpa;

import com.eustachecoding.jpa.models.Author;
import com.eustachecoding.jpa.models.Video;
import com.eustachecoding.jpa.repositories.AuthorRepository;
import com.eustachecoding.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {
			/*var author = Author.builder()
					.firstname("John")
					.lastname("Smith")
					.email("johnsmith@gmail.com")
					.age(43)
					.build();
			repository.save(author);*/

			Video video = Video.builder()
					.name("abc")
					.length(5)
					.url("https://www.google.com/videos/abc")
					.build();
			videoRepository.save(video);
		};
	}

}