package com.nish.Assignment;

import java.util.Scanner;

public class EmailAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmailAnalyzerCheck checker;

        while (true) {

            System.out.println("Enter your mail: ");
            String input = scanner.nextLine();

            checker = new EmailAnalyzerCheck(input);
            
            checker.trimSpaces();
            if (checker.checkSymbol()) {
                break;
            }

            System.out.println("Invalid email. Please enter again.");
        }

        checker.analyze();

        scanner.close();
    }
}