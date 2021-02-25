package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.TypesRepository;

@RestController
public class TypesController {

    final TypesRepository typesRepository;

    public TypesController(TypesRepository typesRepository) {
        this.typesRepository = typesRepository;
    }
}
