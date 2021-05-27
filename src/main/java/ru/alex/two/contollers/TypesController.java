package ru.alex.two.contollers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Types;
import ru.alex.two.service.TypesService;

import java.util.List;


@RestController
@RequestMapping("/types")
public class TypesController {

    private final TypesService typesService;

    @Autowired
    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }


}
