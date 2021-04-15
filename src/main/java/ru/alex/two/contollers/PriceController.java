package ru.alex.two.contollers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Price;
import ru.alex.two.service.PriceService;

import java.util.List;


@RestController
@RequestMapping("/price")
public class PriceController {

    final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @ApiOperation("Запрос все позиций в меню")
    @GetMapping()
    public ResponseEntity<List<Price>> readAll() {
        final List<Price> priceListAll = priceService.readAll();
        return priceListAll != null && priceListAll.isEmpty()
                ? new ResponseEntity<>(priceListAll, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation("Запрос одной позиции меню по id")
    @GetMapping("/price/{id}")
    public ResponseEntity<Price> read(@PathVariable("id") Long id) {
        Price price = priceService.read(id);
        if (price == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(price, HttpStatus.OK);
        }
    }

    @ApiOperation("Добавление новых позиций")
    @PostMapping("/add")
    public void creat(@RequestParam("isActual") Boolean isActual,
                      @RequestParam("name") String name,
                      @RequestParam("cost") Double cost,
                      @RequestParam("weigth") Integer weigth,
                      @RequestParam("typeId") Integer typeId,
                      @RequestParam("description") String description) {
        Price price = new Price(isActual, name, cost, weigth, typeId,
                description);
        priceService.creat(price);
    }

    @ApiOperation("Обновлениие данных о позиции")
    @PutMapping("/update/{id}")
    public ResponseEntity<Price> update(@PathVariable("id") Long id,
                                        @RequestBody Price price) {
        Boolean updatePrice = priceService.update(id, price);
        if (updatePrice == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(price);
        }
    }

}
