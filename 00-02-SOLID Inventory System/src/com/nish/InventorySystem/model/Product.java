package com.nish.InventorySystem.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int reorderLevel;

    public Product(int id, String name, int quantity, int reorderLevel) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }

    public int getId() { 
    	return id; 
    }
    
    public String getName() { 
    	return name; 
    }
    
    public int getQuantity() { 
    	return quantity; 
    }
    public int getReorderLevel() { 
    	return reorderLevel; 
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}