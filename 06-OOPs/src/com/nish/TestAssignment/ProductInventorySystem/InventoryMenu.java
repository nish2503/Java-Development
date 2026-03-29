package com.nish.TestAssignment.ProductInventorySystem;

import java.util.Scanner;

public class InventoryMenu {

    public void displayMenu() {

        System.out.println("\n1. Add Electronics");
        System.out.println("2. Add Clothing");
        System.out.println("3. Display Products");
        System.out.println("4. Exit");
    }

    public void start(InventorySystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice =
                InputHelper.readPositiveInt(scanner,
                        "Enter choice: ");

            switch(choice) {

                case 1:
                    system.addElectronics();
                    break;

                case 2:
                    system.addClothing();
                    break;

                case 3:
                    system.displayProducts();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}