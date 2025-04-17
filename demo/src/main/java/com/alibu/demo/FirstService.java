package com.alibu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private FirstClass firstClass;

    @Autowired
    public void setFirstClass(@Qualifier("bean1") FirstClass firstClass){
        this.firstClass = firstClass;
    }

    public  String tellHistory(){
        return "The dependency is saying : " + firstClass.sayHello();
    }
}
