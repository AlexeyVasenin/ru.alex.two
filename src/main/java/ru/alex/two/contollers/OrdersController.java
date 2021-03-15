package ru.alex.two.contollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.two.domain.Orders;
import ru.alex.two.service.OrdersService;


@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("add")
    public void creat(@RequestHeader String address) {
        Orders order = new Orders(address);
        ordersService.creat(order);

    }

}
