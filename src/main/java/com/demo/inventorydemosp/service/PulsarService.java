package com.demo.inventorydemosp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.inventorydemosp.configuration.PulsarConfiguration;
import com.demo.inventorydemosp.model.*;

import org.apache.pulsar.client.api.*;
import org.apache.pulsar.common.schema.KeyValueEncodingType;
import org.apache.pulsar.client.impl.schema.JSONSchema;

import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.common.schema.KeyValue;

@Component
public class PulsarService {


	@Autowired
	private PulsarConfiguration pulsarConfig; 

    private PulsarClient client;
    private Producer<KeyValue<InventoryKey, Inventory>> producer ;
    
    public void connect()
	{
        try { 
            // Create client object
            client = PulsarClient.builder()
            .serviceUrl(pulsarConfig.getUrl())
            .authentication(
                AuthenticationFactory.token(pulsarConfig.getToken())
            )
            .build();

            Schema<KeyValue<InventoryKey, Inventory>> kv = Schema.KeyValue(JSONSchema.of(InventoryKey.class), JSONSchema.of(Inventory.class), KeyValueEncodingType.SEPARATED);

            producer = client.newProducer(kv)
                             .topic(pulsarConfig.getTopic())                                           
                             .create();

        } catch(PulsarClientException pce) {
            pce.printStackTrace();
        }
		
    }


    public void publish(Product product)
	{
        try { 
            // Create client object
            //PulsarClient client = PulsarClient.builder()
            //.serviceUrl(pulsarConfig.getUrl())
            //.authentication(
            //    AuthenticationFactory.token(pulsarConfig.getToken())
            //)
            //.build();

            //Schema<KeyValue<InventoryKey, Inventory>> kv = Schema.KeyValue(JSONSchema.of(InventoryKey.class), JSONSchema.of(Inventory.class), KeyValueEncodingType.SEPARATED);

            //Producer<KeyValue<InventoryKey, Inventory>> producer = client.newProducer(kv)
            //                                                            .topic(pulsarConfig.getTopic())
            //                                                            .create();

                
            producer.newMessage()
                    .value(new KeyValue<>(new InventoryKey(product.getCategory(), product.getProduct_id()), new Inventory(product.getProduct_name(), product.getQuantity(), product.getPrice())))
                    .send();
                    

            //Close the producer
            producer.close();

            // Close the client
            client.close();


        } catch(PulsarClientException pce) {
            pce.printStackTrace();
        }
		
    }

}