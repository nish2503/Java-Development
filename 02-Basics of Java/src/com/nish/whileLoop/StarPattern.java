package com.nish.whileLoop;
import java.util.Scanner;

public class StarPattern {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            scanner.close();
            return;
        }

        int rows = scanner.nextInt();

        if (rows <= 0) {
            System.out.println("Rows must be greater than 0.");
            scanner.close();
            return;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
