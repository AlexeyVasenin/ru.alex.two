package ru.alex.two.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class IndexController {
    @GetMapping("/")
    public String index(Model model, String name) {
        model.addAttribute("name", name);

        return "index";
    }
}
