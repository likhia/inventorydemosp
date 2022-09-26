package com.demo.inventorydemosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.inventorydemosp.model.ProductList;
import com.demo.inventorydemosp.service.*;

@RestController
@RequestMapping("product")
public class ProductController {
    
    @Autowired
    ProductService service; 

    @GetMapping("/db")
    public ProductList getProductsFromDB()  {
        return service.getProductsFromDB();

    }

    @GetMapping("/db2")
    public ProductList getProductsFromDB2()  {
        return service.getProductsFromDB2();

    }


}
