package ru.alex.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @GetMapping(value = "/hello")
    public List<String> getProducts() {
        List<String> products = new ArrayList<>();
        products.add("Icecream");
        products.add("Beer");
        products.add("Water");
        return products;
    }

    @PostMapping(value = "/hello")
    public String creatProduct() {
        return "Product is saved successfully";
    }
}
