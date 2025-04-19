package com.spring_jpa.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentMapperTest {
    @BeforeEach
    void setUp() {
        System.out.println("Inside before each method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Inside after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first test method");
    }
}