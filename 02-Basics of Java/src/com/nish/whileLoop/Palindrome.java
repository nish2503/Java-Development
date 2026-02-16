package com.nish.whileLoop;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.close();
            return;
        }

        int number = scanner.nextInt();

        if (isPalindrome(number)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }

    public static boolean isPalindrome(int number) {

        if (number < 0) {
            return false; // negative numbers not considered palindrome
        }

        int original = number;
        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        return original == reversed;
    }
}
