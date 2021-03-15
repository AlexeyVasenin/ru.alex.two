package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Types;
import ru.alex.two.service.TypesService;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
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

    @GetMapping("types/list")
    public ResponseEntity<List<Types>> readAll() {
        final List<Types> typesAll = typesService.readAll();
        return typesAll != null && typesAll.isEmpty()
                ? new ResponseEntity<>(typesAll, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("types/{id}")
    public ResponseEntity<Types> read(@PathParam("id") Long id) {
        Types types = typesService.read(id);
        if (types == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
    }

    @PutMapping("types/{id}")
    public ResponseEntity<Types> update(@RequestBody Types types,
                                        @PathParam("id") Long id) {
        Boolean updateTypes = typesService.update(types, id);
        if (updateTypes == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(types, HttpStatus.OK);
        }
    }
}
