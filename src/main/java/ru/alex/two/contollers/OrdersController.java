package ru.alex.two.contollers;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.repository.OrdersRepository;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;


}
