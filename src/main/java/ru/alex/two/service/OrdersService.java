package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.alex.two.domain.Orders;
import ru.alex.two.repository.OrdersRepository;

import java.util.List;

@Service
public class OrdersService {

    Logger logger = LogManager.getLogger(OrdersService.class);

    private final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public void creat(Orders orders) {
        try {
            ordersRepository.save(orders);
        } catch (Exception ex) {
            logger.error(ex);
        }
    }

    public List<Orders> readAll() {
        return ordersRepository.findAll();
    }

    public Orders read(Long id) {
        try {
            return ordersRepository.getOne(id);

        } catch (Exception ex) {
            logger.error(ex);
        }
        return null;
    }

    public Boolean update(Orders orders, Long id) {
        if (ordersRepository.existsById(id)) {
            orders.setId(id);
            ordersRepository.save(orders);
        }
        return false;
    }
}
