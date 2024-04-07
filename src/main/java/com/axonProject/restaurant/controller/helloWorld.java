package com.axonProject.restaurant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {
    @GetMapping("/helloWorld")
    public String helloWorldTest() {
        return "Hello World";
    }
}
