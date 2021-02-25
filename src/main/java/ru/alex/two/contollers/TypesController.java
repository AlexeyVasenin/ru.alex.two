package ru.alex.two.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.TypesRepository;

@RestController
public class TypesController {

    @Autowired
    TypesRepository typesRepository;
}
