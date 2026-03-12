package com.nish.Assignment_2.Model;
import java.util.Scanner;

public class RemoveConsecutiveWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sentence: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        String result = words[0];

        for (int i = 1; i < words.length; i++) {

            if (!words[i].equals(words[i - 1])) {
                result += " " + words[i];
            }
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}