package com.nish.ExceptionHandling.Assignment;

import java.util.Scanner;

public class CustomExceptionInvalidPassword {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter password:");
            String password = scanner.nextLine();

            checkPassword(password);

            System.out.println("Password is valid.");
        }
        catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
        }
        finally {
            System.out.println("Validation process completed.");
            scanner.close();
        }
    }

    public static void checkPassword(String pwd) throws InvalidPasswordException {

        if (pwd.length() < 8) {
            throw new InvalidPasswordException(
                    "Password must be at least 8 characters long.");
        }

        boolean hasDigit = false;

        for (int i = 0; i < pwd.length(); i++) {
            if (Character.isDigit(pwd.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit) {
            throw new InvalidPasswordException(
                    "Password must contain at least one digit.");
        }
    }
}