package com.nish.Encapsulation.Test;
import com.nish.Encapsulation.Model.ProductStatus;
import com.nish.Encapsulation.Model.Product;
import java.util.Scanner;
public class ProductTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String productName;
		double price;
		int stockQuantity;

		while (true) {
			System.out.println("Enter product name : ");
			productName = scanner.nextLine().trim();

			if (productName == null) {
				System.out.println("Product name cant be null!");
				continue;
			}

			if (productName.isEmpty()) {
				System.out.println("Product name cant be empty!");
				continue;
			}
			break;
		}

		while (true) {
			System.out.println("Enter price : ");

			if (!scanner.hasNextDouble()) {
				System.out.println("Invalid input type!");
				scanner.next();
				continue;
			}

			price = scanner.nextDouble();

			if (price <= 0) {
				System.out.println("Invalid price!");
				continue;
			} else {
				break;
			}
		}
		
		while (true) {
			System.out.println("Enter stock quantity : ");

			if (!scanner.hasNextInt()) {
				System.out.println("Invalid input type!");
				scanner.next();
				continue;
			}

			stockQuantity = scanner.nextInt();

			if (stockQuantity <= 0) {
				System.out.println("Invalid quantity!");
				continue;
			} else {
				break;
			}
		}

		Product product = new Product(productName, price, stockQuantity);

		boolean running = true;

		while (running) {
			System.out.println();
			System.out.println("-------WELCOME TO THE MARKET-------");
			System.out.println("1. View Details");
			System.out.println("2. Increase Stock");
			System.out.println("3. Reduce Stock");
			System.out.println("4. Update Price (ADMIN ONLY)");
			System.out.println("5. Discontinue Product");
			System.out.println("6. Exit");
			System.out.println("Choose your operation : ");
			
			if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.next();
                continue;
            }

			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
                System.out.println("Status: " + product.getStatus());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Stock: " + product.getStockQuantity());
                break;

            case 2:
            	if (product.getStatus() == ProductStatus.DISCONTINUED) {
                    System.out.println("Product is discontinued. Cannot process orders.");
                    break;
                }
            	
                System.out.print("Enter quantity to add: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input!");
                    scanner.next();
                    break;
                }

                int addQty = scanner.nextInt();

                if (product.increaseStock(addQty)) {
                    System.out.println("Stock updated successfully!");
                }
                break;

            case 3:
            	if (product.getStatus() == ProductStatus.DISCONTINUED) {
                    System.out.println("Product is discontinued. Cannot process orders.");
                    break;
                }
            	
                System.out.print("Enter order quantity: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input!");
                    scanner.next();
                    break;
                }

                int orderQty = scanner.nextInt();

                if (product.reduceStock(orderQty)) {
                    System.out.println("Order processed successfully!");
                }
                break;

            case 4:
            	if (product.getStatus() == ProductStatus.DISCONTINUED) {
                    System.out.println("Product is discontinued. Cannot update.");
                    break;
                }
            	
                System.out.print("Are you admin? (true/false): ");

                if (!scanner.hasNextBoolean()) {
                    System.out.println("Invalid input!");
                    scanner.next();
                    break;
                }

                boolean isAdmin = scanner.nextBoolean();

                if (!isAdmin) {
                    System.out.println("Only admin can update price.");
                    break;
                }

                System.out.print("Enter new price: ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input!");
                    scanner.next();
                    break;
                }

                double newPrice = scanner.nextDouble();

                if (product.updatePrice(newPrice, isAdmin)) {
                    System.out.println("Price updated successfully!");
                }
                break;

            case 5:
            	if (product.getStatus() == ProductStatus.DISCONTINUED) {
                    System.out.println("Product is already discontinued!");
                    break;
                }
                product.discontinueProduct();
                System.out.println("Product discontinued.");
                break;

            case 6:
                System.out.println("Thank you for visiting!!");
                running = false;
                break;

            default:
                System.out.println("Invalid choice!");
			}
		}
	}

}
