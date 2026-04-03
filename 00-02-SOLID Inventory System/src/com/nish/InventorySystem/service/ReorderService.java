package com.nish.InventorySystem.service;

import com.nish.InventorySystem.model.Product;

public class ReorderService {

    public void reorder(Product product) {
        int reorderQty = 20;
        product.setQuantity(product.getQuantity() + reorderQty);

        System.out.println("Reorder placed for " + reorderQty +
                " units of '" + product.getName() + "'");
    }
}