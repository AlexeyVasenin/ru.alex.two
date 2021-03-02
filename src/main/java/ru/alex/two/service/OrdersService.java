package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrdersService {

    Logger logger = LogManager.getLogger(OrdersService.class);


    private final OrdersService ordersService;

    public OrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }


}
