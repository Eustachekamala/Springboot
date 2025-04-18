package com.spring_rest.spring_rest;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "post-order-record")
    public String postOrderRecord( @RequestBody OrderRecord order ) {
        return "Request accepted and message is: " + order.toString();
    }

    // http://localhost:8080/hello/eustache
    // @GetMapping("/hello/{user-name}")
    @GetMapping(value = "/hello/{username}")
    public String pathVar(
           @PathVariable String username
    ) {
        return "Hello " + username;
    }

    // http://localhost:8080/hello?param_name=param_value&param_name_2=param_value_2
    // @GetMapping("/hello/{user-name}")
    @GetMapping(value = "/hello/param")
    public String paramVar(
            @RequestParam("user-name") String username,
            @RequestParam("user-lastname") String userLastname
    ) {
        return "Hello " + username + " " + userLastname;
    }
}
