package com.nish.InventorySystem.test;

import com.nish.InventorySystem.exception.InvalidInputException;
import com.nish.InventorySystem.model.Product;
import com.nish.InventorySystem.notifier.*;
import com.nish.InventorySystem.service.*;
import com.nish.InventorySystem.util.InputValidation;

import java.util.*;

public class InventorySystem {

    private final Scanner scanner;
    private final InventoryService inventoryService;
    boolean running = true;

    public InventorySystem() {
    	scanner = new Scanner(System.in);

        List<Notifier> notifiers = Arrays.asList(new EmailNotifier(), new SMSNotifier());

        inventoryService = new InventoryService(notifiers, new ReorderService());
    }

    public void start() {
    	
        while (running) {
            try {
                showMenu();
                int choice = InputValidation.getInt(scanner, "Enter choice: ");
                handleChoice(choice);
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error occurred.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n--- Inventory Menu ---");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Update Stock");
        System.out.println("4. View Products");
        System.out.println("5. Exit");
    }

    private void handleChoice(int choice) throws InvalidInputException {
        switch (choice) {
            case 1 -> addProduct();
            case 2 -> removeProduct();
            case 3 -> updateStock();
            case 4 -> inventoryService.viewProducts();
            case 5 -> exit();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addProduct() throws InvalidInputException {
        int id = InputValidation.getInt(scanner, "Enter ID: ");
        String name = InputValidation.getString(scanner, "Enter Name: ");
        int quantity = InputValidation.getInt(scanner, "Enter Quantity: ");
        int reorder = InputValidation.getInt(scanner, "Enter Reorder Level: ");

        Product product = new Product(id, name, quantity, reorder);
        inventoryService.addProduct(product);
    }

    private void removeProduct() throws InvalidInputException {
        int id = InputValidation.getInt(scanner, "Enter ID: ");
        inventoryService.removeProduct(id);
    }

    private void updateStock() throws InvalidInputException {
        int id = InputValidation.getInt(scanner, "Enter ID: ");
        int change = InputValidation.getIntAllowNegative(scanner, "Enter Quantity Change (+/-): ");
        inventoryService.updateStock(id, change);
    }

    private void exit() {
        System.out.println("Exiting...");
        running = false;
    }
}