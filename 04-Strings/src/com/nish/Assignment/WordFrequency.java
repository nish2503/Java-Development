package com.nish.Assignment;

import java.util.Scanner;

public class WordFrequency {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String input = scanner.nextLine();

        WordFrequencyCounter counter = new WordFrequencyCounter(input);
        counter.countFrequency();

        scanner.close();
    }
}