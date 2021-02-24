package ru.alex.two.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "idd")
    private Integer idd;

    @Column(name = "id_user")
    private  Integer idUser;

    @Column(name = "id_prices")
    private Integer idPrices;

    @Column(name = "count")
    private Integer count;

    @Column(name = "sum_prices")
    private Double sumPrices;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "address")
    private String address;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_close")
    private Date dateСlose;

    public Orders(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPrices() {
        return idPrices;
    }

    public void setIdPrices(Integer idPrices) {
        this.idPrices = idPrices;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSumPrices() {
        return sumPrices;
    }

    public void setSumPrices(Double sumPrices) {
        this.sumPrices = sumPrices;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDate_close() {
        return dateСlose;
    }

    public void setDate_close(Date dateСlose) {
        this.dateСlose = dateСlose;
    }
}
