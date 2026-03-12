package com.nish.Assignment;

import java.util.Scanner;

public class SentenceFormatter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String input = scanner.nextLine();
        SentenceFormatterModel formatter = new SentenceFormatterModel(input);
        formatter.formatSentence();
        scanner.close();
    }
}