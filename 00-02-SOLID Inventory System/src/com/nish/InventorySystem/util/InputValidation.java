package com.nish.InventorySystem.util;

import com.nish.InventorySystem.exception.InvalidInputException;

import java.util.Scanner;

public class InputValidation {

	public static int getInt(Scanner scanner, String message) {
	    while (true) {
	        try {
	            System.out.print(message);
	            if (!scanner.hasNextInt()) {
	            	scanner.next();
	                throw new InvalidInputException("Invalid number input.");
	            }

	            int value = scanner.nextInt();

	            if (value < 0) {
	                throw new InvalidInputException("Negative values not allowed.");
	            }
	            return value;
	        } 
	        catch (InvalidInputException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}

	public static String getString(Scanner scanner, String message) {
	    while (true) {
	        try {
	            System.out.print(message);
	            scanner.nextLine(); 
	            String input = scanner.nextLine();

	            if (input.trim().isEmpty()) {
	                throw new InvalidInputException("Input cannot be empty.");
	            }
	            return input;
	        } 
	        catch (InvalidInputException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}
	
	public static int getIntAllowNegative(Scanner scanner, String message) {
	    while (true) {
	        try {
	            System.out.print(message);
	            if (!scanner.hasNextInt()) {
	            	scanner.next();
	                throw new InvalidInputException("Invalid number input.");
	            }
	            return scanner.nextInt();
	        } 
	        catch (InvalidInputException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}
}