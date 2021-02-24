package ru.alex.two.contollers;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {


    private OrdersController ordersController;

    @Autowired
    public OrdersController(OrdersController ordersController) {
        this.ordersController = ordersController;
    }


}
