package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.domain.Types;
import ru.alex.two.service.TypesService;


@RestController
@RequestMapping("/two")
public class TypesController {

    private final TypesService typesService;

    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }

    @PostMapping("/types/creat")
    public void creat(@RequestHeader String name) {
        Types types = new Types(name);
        typesService.creat(types);
    }
}
