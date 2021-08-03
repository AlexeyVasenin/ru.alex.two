package ru.alex.two.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/regis")
    public String regis() {
        return "regis";
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
}
