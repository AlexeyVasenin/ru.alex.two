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



}
