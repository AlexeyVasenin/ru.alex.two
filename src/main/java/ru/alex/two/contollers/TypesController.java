package ru.alex.two.contollers;

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

    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }

    @GetMapping()
    public ResponseEntity<List<Types>> readAll() {
        final List<Types> typesAll = typesService.readAll();
        return typesAll != null && typesAll.isEmpty()
                ? new ResponseEntity<>(typesAll, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Types> read(@PathVariable("id") Long id) {
        Types types = typesService.read(id);
        if (types == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
    }

    @PostMapping()
    public void creat(@RequestParam String name) {
        Types types = new Types(name);
        typesService.creat(types);
    }
}
