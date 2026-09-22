package com.ga.todo.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("Our app is working fine ...");
        return "All good so far";
    }
}
