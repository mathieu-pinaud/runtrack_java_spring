package com.example.jour2.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @Value("${greeting.message}")
    private String message;

    @GetMapping("/")
    public String Hello() {
        return message;
    }
}
