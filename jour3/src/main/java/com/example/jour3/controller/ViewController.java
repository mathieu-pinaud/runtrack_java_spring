package com.example.jour3.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jour3.User;

import java.util.List;
import org.springframework.ui.Model;

@RestController
public class ViewController {
    
    @GetMapping("view")
    public String view(Model model) {
        List<String> items = List.of("Hello", "Spring", "Boot");
        model.addAttribute("message", "Hello, Spring Boot!");
        model.addAttribute("items", items);
        return "view";
    }

     @PostMapping("view")
    public String welcome(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("message", "Hello, Spring Boot!");
        model.addAttribute("items", List.of("Hello", "Spring", "Boot"));
        model.addAttribute("welcomeMessage", "Alors la zone ? " + user.getName() + " " + user.getAge());
        return "view"; // Redirige vers la vue avec le message de bienvenue
    }
}