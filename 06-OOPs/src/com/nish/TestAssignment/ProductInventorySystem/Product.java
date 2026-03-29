package com.nish.TestAssignment.ProductInventorySystem;

public abstract class Product {

    private int productId;
    private String productName;
    private double basePrice;

    public Product(int productId, String productName, double basePrice) {

        if(basePrice < 0)
            throw new IllegalArgumentException("Invalid price.");

        this.productId = productId;
        this.productName = productName;
        this.basePrice = basePrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void displayDetails() {

        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Base Price: " + basePrice);
    }
}