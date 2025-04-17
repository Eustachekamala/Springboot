package com.spring_rest.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(SpringRestApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx = app.run(args);

	}

}
