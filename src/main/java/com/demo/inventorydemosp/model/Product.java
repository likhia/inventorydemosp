package com.demo.inventorydemosp.model;

import java.math.BigDecimal;

public class Product {
    private String category; 
    private String product_id;
    private String product_name;
    private Double price;
    private Integer quantity;
    
    public Product() {

    }

    public Product(String category, String product_id, String product_name, Double price, Integer quantity) {
        this.category = category;
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
   
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    } 

    
}
