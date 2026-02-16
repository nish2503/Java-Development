package com.nish.whileLoop;
import java.util.Scanner;

public class PrimePattern {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter limit: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            scanner.close();
            return;
        }

        int limit = scanner.nextInt();

        if (limit < 2) {
            System.out.println("No prime numbers available.");
            scanner.close();
            return;
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }

    public static boolean isPrime(int number) {

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0)
                return false;
        }

        return true;
    }
}
