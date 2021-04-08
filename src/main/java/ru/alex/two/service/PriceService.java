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

    public void creat(Price price) {
        try {
            priceRepository.save(price);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    public List<Price> readAll() {
        return priceRepository.findAll();
    }

    public Price read(Long id) {
        try {
            return priceRepository.getOne(id);
        } catch (Exception ex) {
            logger.error(ex);
        }
        return null;
    }

    public Boolean update(Long id, Price price) {
        if (priceRepository.existsById(id)) {
            price.setId(id);
            priceRepository.save(price);
            return true;

        }
        return false;
    }
}
