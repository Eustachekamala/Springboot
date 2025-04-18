package com.spring_rest.spring_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello World from Spring REST";
    }

    @PostMapping(value = "/post")
    public String post( @RequestBody String message ) {
        return "Request accepted and message is: " + message;
    }

    @PostMapping(value = "post-order")
    public String postOrder( @RequestBody Order order ) {
        return "Request accepted and message is: " + order.toString();
    }
}
