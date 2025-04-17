package com.alibu.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:custom.properties")
public class FirstService {

    private final FirstClass firstClass;

    @Value("${spring.application.name}")
    private String customProperty;

    @Value("${my.prop}")
    private String customPropertyFormAnotherFile;

    public FirstService(
           @Qualifier("bean1") FirstClass firstClass) {
        this.firstClass = firstClass;
    }

    public  String tellHistory(){
        return "The dependency is saying : " + firstClass.sayHello();
    }

    public String getCustomPropertyFormAnotherFile() {
        return customPropertyFormAnotherFile;
    }

    public String getCustomProperty() {
        return customProperty;
    }
}
