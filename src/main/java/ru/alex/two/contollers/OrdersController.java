package ru.alex.two.contollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Orders;
import ru.alex.two.service.OrdersService;

import java.util.Date;
import java.util.List;


@RestController
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/orders/add")
    public void add(@RequestParam Integer count,
                    @RequestParam Double sumPrices,
                    @RequestParam Double cost,
                    @RequestParam String address) {

        Date dateCreate = new Date();
        Date dateClose = new Date();

        Orders order = new Orders(count, sumPrices, cost, address, dateCreate,
                dateClose);
        ordersService.creat(order);
    }

    @GetMapping("/orders/list")
    public ResponseEntity<List<Orders>> readAll() {
        final List<Orders> orders = ordersService.readAll();
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Orders> update(@RequestBody Orders orders,
                                         @PathVariable("id") Long id) {
        Boolean updateOrders = ordersService.update(orders, id);
        if (updateOrders == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }
}
