package ru.alex.two.contollers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Price;
import ru.alex.two.domain.SimpleResult;
import ru.alex.two.service.PriceService;

import java.util.List;


@RestController
@RequestMapping("/api.price")
public class PriceController {

    final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }


    @ApiOperation("Получение списка товаров")
    @GetMapping("/get/all")
    @ResponseBody
    public SimpleResult<List<Price>> getAll() {
        return new SimpleResult<>(priceService.getAll());
    }

    @Getter
    @Setter
    public static class SavePriceResp {
        private Boolean isActual;
        private String name;
        private Double cost;
        private Integer weight;
        private Integer typeId;
        private String description;
    }

    @ApiOperation("Создание товара")
    @PostMapping("/add")
    @ResponseBody
    public SimpleResult<Price> create(@RequestBody SavePriceResp resp) {
        return new SimpleResult<>(priceService.save(resp));
    }

    @Getter
    @Setter
    public static class UpdatePriceStatus {
        private long id;
        private Boolean isActual;
        private Double cost;

    }

    @ApiOperation("Обновление данные товара")
    @PutMapping("/add")
    @ResponseBody
    public SimpleResult<Price> update(@RequestBody UpdatePriceStatus status) {
        return new SimpleResult<>(priceService.update(status));
    }

    @Getter
    @Setter
    public static class SortPrice {
        private Double cost;

    }

    @ApiOperation("Сортировка по цене")
    @PostMapping("/search")
    @ResponseBody
    public SimpleResult<List<Price>> sortBy(@RequestBody SortPrice sortPrice) {
        return new SimpleResult<>(priceService.findByPrice(sortPrice.getCost()));
    }

}
