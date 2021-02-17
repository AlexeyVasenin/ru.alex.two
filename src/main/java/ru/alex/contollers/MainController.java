package ru.alex.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {

    @GetMapping(value = "/hello")
    public String getProducts() {
        return "This is hello";
    }

    @PostMapping(value = "/hello")
    public String creatProduct() {
        return "Product is saved successfully";
    }
}
