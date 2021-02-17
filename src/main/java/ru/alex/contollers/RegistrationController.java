package ru.alex.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.alex.repos.MainRepo;

public class RegistrationController {

    @Autowired
    MainRepo mainRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(){
        return "redirect:/login";
    }

}
