package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alex.two.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}