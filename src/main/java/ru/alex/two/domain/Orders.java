package ru.alex.two.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idd")
    private Integer idd;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "price_id")
    private Integer priceId;

    /*Кол-во позиций в чеке*/
    @Column(name = "count")
    private Integer count;

    /*Общая сумма заказа*/
    @Column(name = "sum_prices")
    private Double sumPrices;

    /*Сумма отдельной позиции в чеке*/
    @Column(name = "cost")
    private Double cost;

    @Column(name = "address")
    private String address;

    @Column(name = "date_create")
    private String dateCreate;

    @Column(name = "date_close")
    private String dateСlose;
}
