package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.PriceRepository;

@RestController
public class PriceContoller {

    final PriceRepository priceRepository;

    public PriceContoller(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
}
