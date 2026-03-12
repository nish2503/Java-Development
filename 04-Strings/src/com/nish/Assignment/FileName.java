package com.nish.Assignment;

import java.util.Scanner;

public class FileName {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String input = scanner.nextLine();

        FileNameValidator validator = new FileNameValidator(input);
        validator.validate();

        scanner.close();
    }
}