package com.alibu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var app = new SpringApplication(DemoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.profiles.active","dev"));
		var ctx = app.run(args);

		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.tellHistory());
		System.out.println(firstService.getCustomProperty());
		System.out.println(firstService.getCustomPropertyFormAnotherFile());
	}

}
