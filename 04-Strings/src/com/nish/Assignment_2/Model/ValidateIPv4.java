package com.nish.Assignment_2.Model;
import java.util.Scanner;

public class ValidateIPv4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter IP address: ");
        String ip = scanner.nextLine();

        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            System.out.println("Invalid IP");
            scanner.close();
            return;
        }

        for (String part : parts) {

            int num = Integer.parseInt(part);

            if (num < 0 || num > 255) {
                System.out.println("Invalid IP");
                scanner.close();
                return;
            }
        }

        System.out.println("Valid IP");

        scanner.close();
    }
}