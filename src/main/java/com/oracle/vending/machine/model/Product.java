package com.oracle.vending.machine.model;

public class Product {
    private String productName;
    private float price;

    public Product() {
    }

    public Product(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
