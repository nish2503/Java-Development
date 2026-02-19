package com.nish.Encapsulation.Model;

public class Product {
	private final String productID = "PID54321";
	private String productName;
	private double price;
	private int stockQuantity;
	private ProductStatus status;
	
	public Product(String productName, double price, int stockQuantity) {
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
		this.status = ProductStatus.ACTIVE;
	}
	
	public boolean increaseStock(int quantity) {
		if(status == ProductStatus.ACTIVE) {
			if(quantity > 0) {
				stockQuantity += quantity;
				return true;
			}
			else {
				System.out.println("Invalid quantity!");
				return false;
			}
		}
		else {
			System.out.println("Cannot update discontinued product.");
			return false;
		}
	}
	
	public boolean reduceStock(int quantity) {
		if(status == ProductStatus.ACTIVE) {
			if(quantity > 0 && quantity <= stockQuantity) {
				stockQuantity -= quantity;
				return true;
			}
			else {
				System.out.println("Invalid quantity!");
				return false;
			}
		}
		else {
			System.out.println("Cannot update discontinued product.");
			return false;
		}
	}
	
	public boolean updatePrice(double newPrice, boolean isAdmin) {
		if (!isAdmin) {
            System.out.println("Only admin can update price.");
            return false;
        }
		if(newPrice > 0) {
			this.price = newPrice;
			return true;
		}
		else {
			System.out.println("Invalid price!");
			return false;
		}
	}
	
	public void discontinueProduct() {
		this.status = ProductStatus.DISCONTINUED;
	}
	
	public ProductStatus getStatus() {
        return status;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }
}
