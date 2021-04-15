package ru.alex.two.contollers;

import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Запрос всех заказов")
    @GetMapping()
    public ResponseEntity<List<Orders>> readAll() {
        final List<Orders> orders = ordersService.readAll();
        return orders != null && !orders.isEmpty()
                ? new ResponseEntity<>(orders, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation("Запрос одного заказа по id")
    @GetMapping("/order/{id}")
    public ResponseEntity<Orders> read(@PathVariable("id") Long id) {
        Orders orders = ordersService.read(id);
        if (orders == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        }
    }

    @ApiOperation("Регистрация нового заказа")
    @PostMapping("/add")
    public void add(@RequestParam("count") Integer count,
                    @RequestParam("sumPrice") Double sumPrices,
                    @RequestParam("cost") Double cost,
                    @RequestParam("address") String address) {

        Orders order = new Orders(count, sumPrices, cost, address);
        ordersService.creat(order);
    }

    @ApiOperation("Обновление заказа")
    @PutMapping("/update/{id}")
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
