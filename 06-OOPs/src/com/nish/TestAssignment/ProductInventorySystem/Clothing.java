package com.nish.TestAssignment.ProductInventorySystem;

public class Clothing extends Product {

    private String size;

    public Clothing(int id, String name, double price, String size) {

        super(id, name, price);
        this.size = size;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Category: Clothing");
        System.out.println("Size: " + size);
    }
}
