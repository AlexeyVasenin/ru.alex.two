package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Price;
import ru.alex.two.service.PriceService;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class PriceController {

    final
    PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/price/creat")
    public void creat(@RequestHeader Boolean isActual,
                      @RequestHeader String name,
                      @RequestHeader Double cost,
                      @RequestHeader Integer weigth,
                      @RequestHeader Integer typeId,
                      @RequestHeader String description) {
        Price price = new Price(isActual, name, cost, weigth, typeId,
                description);
        priceService.creat(price);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Price> read(@PathParam("id") Long id) {
        Price price = priceService.read(id);
        if (price == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(price, HttpStatus.OK);
        }
    }

    @GetMapping("/price/list")
    public ResponseEntity<List<Price>> readAll() {
        final List<Price> priceListAll = priceService.readAll();
        return priceListAll != null && priceListAll.isEmpty()
                ? new ResponseEntity<>(priceListAll, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/price/{id}")
    public ResponseEntity<Price> update(@RequestBody Price price,
                                        @PathParam("id") Long id) {
        Boolean updatePrice = priceService.update(price, id);
        if (updatePrice == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(price);
        }
    }

}
