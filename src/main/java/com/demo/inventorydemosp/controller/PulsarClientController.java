package com.demo.inventorydemosp.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.inventorydemosp.model.Product;
import com.demo.inventorydemosp.service.PulsarService;

@Controller
@RequestMapping("/pulsar")
public class PulsarClientController {
    
    @Autowired
    PulsarService service;

    @RequestMapping(path="/connect", method = RequestMethod.GET)
    public String connect() {
        service.connect();

        return "SUCCESS";
    }
    @RequestMapping(path="/publish", method = RequestMethod.POST)
    public String publishToPulsar(@RequestParam String category, @RequestParam String productid, @RequestParam String productname, @RequestParam Double price, @RequestParam Integer quantity) {
        
        service.publish(new Product(category, productid, productname, price, quantity));

        return "redirect:/index.html";
    }

}
