package com.spring_jpa.spring_data_jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @PostMapping
    public String post(
            @RequestBody String message
    ) {
        return "Hello " + message;
    }
}
