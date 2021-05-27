package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.Price;
import ru.alex.two.repository.PriceRepository;

import java.util.List;

@Service
public class PriceService {

    private final Logger logger = LogManager.getLogger(PriceService.class);

    private final PriceRepository priceRepository;

    @Autowired
    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

}
