package com.codegym.casestudymodule3;

import java.util.Date;

public class Order {
    int id;
    String name;
    int price;
    String customerName;
    Date orderDate;

    public Order(int id, String name, int price, String customerName, Date orderDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
