package com.nish.InventorySystem.service;

import com.nish.InventorySystem.model.Product;
import com.nish.InventorySystem.notifier.Notifier;

import java.util.*;

public class InventoryService {

    private Map<Integer, Product> productMap = new HashMap<>();
    private List<Notifier> notifiers;
    private ReorderService reorderService;

    public InventoryService(List<Notifier> notifiers, ReorderService reorderService) {
        this.notifiers = notifiers;
        this.reorderService = reorderService;
    }

    public void addProduct(Product product) {
        productMap.put(product.getId(), product);
        System.out.println("Product added successfully.");
    }

    public void removeProduct(int id) {
        if (!productMap.containsKey(id)) {
            System.out.println("Product not found.");
            return;
        }
        productMap.remove(id);
        System.out.println("Product removed.");
    }

    public void updateStock(int id, int quantityChange) {
        Product product = productMap.get(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        int newQuantity = product.getQuantity() + quantityChange;

        if (newQuantity < 0) {
            System.out.println("Stock cannot be negative.");
            return;
        }

        product.setQuantity(newQuantity);

        System.out.println("Stock updated for " + product.getName() +
                ". Current stock: " + newQuantity);

        checkReorder(product);
    }

    private void checkReorder(Product product) {
        if (product.getQuantity() <= product.getReorderLevel()) {

            System.out.println("Reorder threshold reached for '" 
            					+ product.getName() + "'");

            reorderService.reorder(product);

            for (Notifier notifier : notifiers) {
                notifier.notify("Low stock alert for '" 
                				+ product.getName() + "'");
            }
        }
    }

    public void viewProducts() {
        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : productMap.values()) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() +
                    			", Qty: " + p.getQuantity());
        }
    }
}