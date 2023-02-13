package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.contollers.PriceController;
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

    public List<Price> getAll() {
        return priceRepository.findAll();
    }

    public Price getOne(Long id) {
        return priceRepository.findById(id).orElseGet(() -> null);
    }

    public Price save(PriceController.SavePriceResp resp) {
        Price price = new Price();
        price.setIsActual(resp.getIsActual());
        price.setName(resp.getName());
        price.setCost(resp.getCost());
        price.setWeight(resp.getWeight());
        price.setTypeId(resp.getTypeId());
        price.setDescription(resp.getDescription());

        return priceRepository.save(price);
    }

    public Price update(PriceController.UpdatePriceStatus status) {
        Price updatePrice = priceRepository.getOne(status.getId());
        updatePrice.setIsActual(status.getIsActual());
        updatePrice.setCost(status.getCost());
        return priceRepository.save(updatePrice);
    }

    public List<Price> findByPrice(Double cost) {
        return priceRepository.findPriceByCost(cost);
    }


}
