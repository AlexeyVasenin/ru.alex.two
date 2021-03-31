package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Price;
import ru.alex.two.service.PriceService;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequestMapping("/cafe")
public class PriceController {

    final
    PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/price")
    public ResponseEntity<List<Price>> readAll() {
        final List<Price> priceListAll = priceService.readAll();
        return priceListAll != null && priceListAll.isEmpty()
                ? new ResponseEntity<>(priceListAll, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Price> read(@PathVariable("id") Long id) {
        Price price = priceService.read(id);
        if (price == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(price, HttpStatus.OK);
        }
    }

    @PostMapping("/price")
    public void creat(@RequestParam Boolean isActual,
                      @RequestParam String name,
                      @RequestParam Double cost,
                      @RequestParam Integer weigth,
                      @RequestParam Integer typeId,
                      @RequestParam String description) {
        Price price = new Price(isActual, name, cost, weigth, typeId,
                description);
        priceService.creat(price);
    }

    @PutMapping("/price/{id}")
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
