package com.alibu.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {
    @Bean("myBean")
    public FirstClass firstClass(){
        return new FirstClass("First bean");
    }
}
