package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.alex.two.repository.PriceRepository;

public class PriceService {
    Logger log = LogManager.getLogger(PriceService.class);

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
}
