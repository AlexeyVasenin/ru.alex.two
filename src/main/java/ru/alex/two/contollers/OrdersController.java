package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.OrdersRepository;

@RestController
public class OrdersController {

    private final OrdersRepository ordersRepository;


    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }
}
