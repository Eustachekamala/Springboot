package com.eustachecoding.jpa;

import com.eustachecoding.jpa.models.Author;
import com.eustachecoding.jpa.models.Course;
import com.eustachecoding.jpa.models.Video;
import com.eustachecoding.jpa.repositories.AuthorRepository;
import com.eustachecoding.jpa.repositories.CourseRepository;
import com.eustachecoding.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Locale;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository,
			CourseRepository courseRepository
	) {
		return args -> {
			/*for( int i = 0; i < 50; i++ ) {
				Faker faker = new Faker();

				var author = Author.builder()
						.firstname(faker.name().firstName())
						.lastname(faker.name().lastName())
						.email(faker.internet().emailAddress())
						.age(faker.number().numberBetween(19, 80))
						.build();
				repository.save(author);
			}*/

			/*Video video = Video.builder()
					.name("abc")
					.length(5)
					.url("https://www.google.com/videos/abc")
					.build();
			videoRepository.save(video);*/
//			for( int i = 0; i < 10; i++ ) {
//				Faker faker = new Faker();
//				Course course = Course.builder()
//						.title(faker.book().title())
//						.description(faker.book().author())
//						.build();
//				courseRepository.save(course);
//			}

		};
	}

}