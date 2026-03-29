package com.nish.TestAssignment.ProductInventorySystem;

import java.util.Scanner;

public class InventorySystem {

    private Scanner scanner = new Scanner(System.in);
    private Product[] products;
    private int count = 0;

    private InventoryMenu menu = new InventoryMenu();

    public InventorySystem() {

        int size =
            InputHelper.readPositiveInt(scanner,
                    "Enter number of products: ");

        products = new Product[size];
    }

    public Scanner getScanner() {
        return scanner;
    }


    public void addElectronics() {

        int id =
            InputHelper.readPositiveInt(scanner,
                    "Enter Product ID: ");

        String name =
            InputHelper.readName(scanner,
                    "Enter Product Name: ");

        double price =
            InputHelper.readPositiveDouble(scanner,
                    "Enter Price: ");

        int warranty =
            InputHelper.readPositiveInt(scanner,
                    "Enter Warranty Months: ");

        products[count++] =
            new Electronics(id, name, price, warranty);
    }


    public void addClothing() {

        int id =
            InputHelper.readPositiveInt(scanner,
                    "Enter Product ID: ");

        String name =
            InputHelper.readName(scanner,
                    "Enter Product Name: ");

        double price =
            InputHelper.readPositiveDouble(scanner,
                    "Enter Price: ");

        String size =
            InputHelper.readName(scanner,
                    "Enter Size: ");

        products[count++] =
            new Clothing(id, name, price, size);
    }


    public void displayProducts() {

        if(count == 0) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Product Inventory ---");

        for(int i = 0; i < count; i++) {

            products[i].displayDetails();
            System.out.println("----------------------");
        }
    }


    public static void main(String[] args) {

        InventorySystem system = new InventorySystem();
        system.menu.start(system, system.scanner);
    }
}