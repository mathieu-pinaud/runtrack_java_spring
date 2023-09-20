package com.example.jour2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jour2.User;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
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