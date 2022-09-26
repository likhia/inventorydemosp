package com.demo.inventorydemosp.model;

import java.util.List;
import java.util.ArrayList;

public class ProductList {
    
    private List<Product> products = null;



    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductList() {
        products = new ArrayList<Product>();
    }

    public ProductList(List<Product> products) {
        this.products = products;
    } 

    public void add(Product product) {
        products.add(product);
    }

    

}
