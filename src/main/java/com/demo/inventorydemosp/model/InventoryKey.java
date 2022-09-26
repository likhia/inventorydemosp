package com.demo.inventorydemosp.model;

public class InventoryKey {
    private String category;
    private String product_id;

    public InventoryKey() {
        super();
    }

    public InventoryKey(String category, String productId) {
        this.category = category;
        this.product_id = productId;
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
}
