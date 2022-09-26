package com.demo.inventorydemosp.model;

import java.math.BigDecimal;

public class Inventory {
    private String product_name;
    private Integer quantity;
    private Double price;

    public Inventory() {
        super();
    }

    public Inventory(String productName, Integer quantity, Double price) {
        this.product_name = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
}
