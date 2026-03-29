package com.nish.TestAssignment.ProductInventorySystem;

public class Electronics extends Product {

    private int warrantyMonths;

    public Electronics(int id, String name,
                       double price, int warrantyMonths) {

        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public void displayDetails() {

        super.displayDetails();
        System.out.println("Category: Electronics");
        System.out.println("Warranty (months): " + warrantyMonths);
    }
}