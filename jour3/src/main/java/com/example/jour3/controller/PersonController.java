package com.example.jour3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jour3.Person;
import com.example.jour3.PersonRepository;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("person", new Person()); // Ajoutez un objet Person vide pour le formulaire de création
        return "persons";
    }

    @PostMapping("/persons/create")
    public String createPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/persons"; // Redirigez vers la liste des personnes après la création
    }

    @GetMapping("/persons/edit/{id}")
    public String editPersonForm(@PathVariable Long id, Model model) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        model.addAttribute("person", person);
        return "persons";
    }

    @PostMapping("/persons/edit/{id}")
    public String updatePerson(@PathVariable Long id, @ModelAttribute Person updatedPerson) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        person.setName(updatedPerson.getName());
        person.setAge(updatedPerson.getAge());
        personRepository.save(person);
        return "redirect:/persons"; // Redirigez vers la liste des personnes après la mise à jour
    }

    @PostMapping("/persons/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        personRepository.delete(person);
        return "redirect:/persons"; // Redirigez vers la liste des personnes après la suppression
    }
}
