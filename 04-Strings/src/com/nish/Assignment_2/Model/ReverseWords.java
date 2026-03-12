package com.nish.Assignment_2.Model;
import java.util.Scanner;

public class ReverseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        for (String word : words) {

            String reversed = "";

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed += word.charAt(i);
            }

            System.out.print(reversed + " ");
        }

        scanner.close();
    }
}