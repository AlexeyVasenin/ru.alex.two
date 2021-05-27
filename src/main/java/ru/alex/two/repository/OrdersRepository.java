package ru.alex.two.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.alex.two.domain.Orders;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query("select o from Orders o where o.userId = :id")
    List<Orders> findAllUsers(@Param("id") Long id);

}