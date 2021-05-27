package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.contollers.OrdersController;
import ru.alex.two.domain.Orders;
import ru.alex.two.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService {

    private final Logger logger = LogManager.getLogger(OrdersService.class);

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAll() {
        return ordersRepository.findAll();
    }

    public Orders getOne(Long id) {
        return ordersRepository.findById(id).orElseGet(() -> null);
    }


    public Orders save(OrdersController.SaveOrdersResp resp) {
        Orders orders = new Orders();
        orders.setCount(resp.getCount());
        orders.setSumPrices(resp.getSumPrices());
        orders.setCost(resp.getCost());
        orders.setAddress(resp.getAddress());
        orders.setDateCreate(resp.getDateCreate());
        orders.setDateCreate(resp.getDateСlose());

        return orders;
    }

    public Orders update(Orders orders) {
        return ordersRepository.save(orders);
    }

    public List<Orders> findByUser(Long id) {
        return ordersRepository.findAllUsers(id);
    }

}
