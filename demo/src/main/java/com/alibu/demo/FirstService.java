package com.alibu.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:custom.properties")
public class FirstService {

    private final FirstClass firstClass;

    @Value("Hello Alibu students")
    private String customProperty;

    @Value("${my.prop}")
    private String customPropertyFormAnotherFile;

    @Value("123")
    private String customPropertyInt;

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

    public String getCustomPropertyInt() {
        return customPropertyInt;
    }
}
