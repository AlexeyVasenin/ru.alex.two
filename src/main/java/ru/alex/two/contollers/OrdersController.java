package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.service.OrdersService;

@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }
}
