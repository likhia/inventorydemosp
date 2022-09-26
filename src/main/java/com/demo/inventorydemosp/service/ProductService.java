package com.demo.inventorydemosp.service;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import com.demo.inventorydemosp.configuration.AstraDBConfiguration;
import com.demo.inventorydemosp.configuration.AstraDBConfiguration2;
import com.demo.inventorydemosp.model.ProductList;
import com.demo.inventorydemosp.model.Data;

@Component
public class ProductService {

    @Autowired
    AstraDBConfiguration dbConfig;

    @Autowired
    AstraDBConfiguration2 dbConfig2; 

    public ProductList getProductsFromDB() {
        
        String baseURL =  getBaseURLFromDB() + "rows";
        
        ProductList list = new ProductList();

        try { 
            RestTemplate restTemplate = new RestTemplate();

            URI uri = new URI(baseURL);
        
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-cassandra-token", dbConfig.getToken());
            

            HttpEntity<Data> requestEntity = new HttpEntity<>(null, headers);
            
            ResponseEntity<Data> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Data.class);
                
            return new ProductList(result.getBody().getData());
            
        } catch(java.net.URISyntaxException urlse) {
            urlse.printStackTrace();
        } 
        return list; 
    }

    public ProductList getProductsFromDB2() {
        
        String baseURL =  getBaseURLFromDB2() + "rows";
        
        ProductList list = new ProductList();

        try { 
            RestTemplate restTemplate = new RestTemplate();

            URI uri = new URI(baseURL);
        
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-cassandra-token", dbConfig2.getToken());
            

            HttpEntity<Data> requestEntity = new HttpEntity<>(null, headers);
            
            ResponseEntity<Data> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Data.class);
                
            return new ProductList(result.getBody().getData());
            
        } catch(java.net.URISyntaxException urlse) {
            urlse.printStackTrace();
        } 
        return list; 
    }


    public String getBaseURLFromDB() {
        return "https://" + dbConfig.getId() + "-" + dbConfig.getRegion() + ".apps.astra.datastax.com/api/rest/v2/keyspaces/" + dbConfig.getKeyspace() + "/inventory_by_category/";
        
    }

    public String getBaseURLFromDB2() {
        return "https://" + dbConfig2.getId() + "-" + dbConfig2.getRegion() + ".apps.astra.datastax.com/api/rest/v2/keyspaces/" + dbConfig2.getKeyspace() + "/inventory_by_category/";
        
    }
}
