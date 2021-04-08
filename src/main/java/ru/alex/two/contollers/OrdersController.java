package ru.alex.two.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Orders;
import ru.alex.two.service.OrdersService;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping()
    public ResponseEntity<List<Orders>> readAll() {
        final List<Orders> orders = ordersService.readAll();
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> read(@PathVariable("id") Long id) {
        Orders orders = ordersService.read(id);
        if (orders == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
    }

    @PostMapping()
    public void add(@RequestParam("count") Integer count,
                    @RequestParam("sumPrice") Double sumPrices,
                    @RequestParam("cost") Double cost,
                    @RequestParam("address") String address) {

        Date dateCreate = new Date();
        Date dateClose = new Date();

        Orders order = new Orders(count, sumPrices, cost, address, dateCreate,
                dateClose);
        ordersService.creat(order);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Orders> update(@PathVariable("id") Long id,
                                         @RequestBody Orders orders) {
        Boolean updateOrders = ordersService.update(id, orders);
        if (updateOrders == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }
}
