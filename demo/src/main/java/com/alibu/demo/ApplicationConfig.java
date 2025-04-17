package com.alibu.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ApplicationConfig {
    @Bean("bean1")
    public FirstClass firstBean(){
        return new FirstClass("First bean");
    }

    @Bean
    public FirstClass secondBean(){
        return new FirstClass("Second bean");
    }

    @Bean
//    @Primary
    public FirstClass thirdBean(){
        return new FirstClass("Third bean");
    }
}
