package com.example.robin.spring.demo.robins.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class studentController {

    @RequestMapping("/")
    public String index() {
        return "Hello from the students!";
    }
}
