package com.alibu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(DemoApplication.class, args);

		FirstService firstService = ctx.getBean(FirstService.class);
		System.out.println(firstService.tellHistory());
		System.out.println(firstService.getCustomPropertyFormAnotherFile());
	}

}
