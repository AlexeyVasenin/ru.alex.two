package ru.alex.two.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alex.two.contollers.OrdersController;
import ru.alex.two.domain.Orders;
import ru.alex.two.repository.OrdersRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String dateCrate =
                new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        orders.setCount(resp.getCount());
        orders.setSumPrices(resp.getSumPrices());
        orders.setCost(resp.getCost());
        orders.setAddress(resp.getAddress());
        orders.setDateCreate(dateCrate);
        orders.setStatus(true);

        return ordersRepository.save(orders);
    }

    public Orders update(OrdersController.UpdateOrdersStatus status) {
        Orders updateOrders = ordersRepository.getOne(status.getId());
        String dateClose =
                new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        updateOrders.setStatus(status.getStatus());
        updateOrders.setDateСlose(dateClose);
        return ordersRepository.save(updateOrders);
    }

    public List<Orders> findByUser(Integer id) {
        return ordersRepository.findAllUsers(id);
    }

}
