package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.two.domain.Price;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findPriceByCost(Double aDouble);

}