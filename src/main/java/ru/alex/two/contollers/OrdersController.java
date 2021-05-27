package ru.alex.two.contollers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liquibase.pro.packaged.L;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.alex.two.domain.Orders;
import ru.alex.two.domain.SimpleResult;
import ru.alex.two.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @ApiOperation("Получить список заказов")
    @GetMapping("/orders")
    @ResponseBody
    public SimpleResult<List<Orders>> getAll() {
        return new SimpleResult<>(ordersService.getAll());
    }

    @Getter
    @Setter
    public static class SaveOrdersResp {
        private Integer count;
        private Double sumPrices;
        private Double cost;
        private String address;
        private Boolean status;

    }

    @ApiOperation("Создание заказа")
    @PostMapping("/orders")
    @ResponseBody
    public SimpleResult<Orders> create(@RequestBody SaveOrdersResp resp) {
        return new SimpleResult<>(ordersService.save(resp));
    }

    @Getter
    @Setter
    public static class UpdateOrdersStatus {
        private long id;
        private Boolean status;
    }

    @ApiOperation("Обновить данные заказа")
    @PutMapping("/orders")
    @ResponseBody
    public SimpleResult<Orders> update(@RequestBody UpdateOrdersStatus status) {
        return new SimpleResult<>(ordersService.update(status));
    }

    @Getter
    @Setter
    public static class SortOrdersUsers {
        private Integer id;
    }

    @ApiOperation("Сортировка заказа по id пользователя")
    @PostMapping("/orders/s/user")
    @ResponseBody
    public SimpleResult<List<Orders>> sortByUser(@RequestBody SortOrdersUsers sortOrdersUsers) {
        return new SimpleResult<>(ordersService.findByUser(sortOrdersUsers.getId()));
    }
}
