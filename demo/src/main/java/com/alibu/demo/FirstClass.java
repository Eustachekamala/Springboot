package com.alibu.demo;

public class FirstClass {

    private String myVar;

    public FirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return  "Hello from my FistClass ==> myVar= " + myVar;
    }
}
