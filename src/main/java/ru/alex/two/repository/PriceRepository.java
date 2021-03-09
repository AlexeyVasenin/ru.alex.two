package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.two.domain.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

}