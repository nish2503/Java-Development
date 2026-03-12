package com.nish.Assignment_2.Model;
import java.util.Scanner;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String str = scanner.nextLine();

        for (int i = 0; i < str.length(); i++) {

            boolean unique = true;

            for (int j = 0; j < str.length(); j++) {

                if (i != j && str.charAt(i) == str.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                System.out.println("First non-repeating character: " + str.charAt(i));
                scanner.close();
                return;
            }
        }

        System.out.println("No unique character found");

        scanner.close();
    }
}