package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.domain.Orders;
import ru.alex.two.service.OrdersService;

import java.util.Date;


@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("add")
    public void add(@RequestParam String address) {

        Date creatDate = new Date();

        Orders order = new Orders(address, creatDate);
        ordersService.creat(order);

    }

}
