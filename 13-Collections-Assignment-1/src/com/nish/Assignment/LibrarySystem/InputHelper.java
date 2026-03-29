package com.nish.Assignment.LibrarySystem;
import java.util.Scanner;

public class InputHelper {
    private Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public String readString(String msg) {
    	while (true) {

            System.out.print(msg);

            String name = scanner.nextLine().trim();
            name = name.replaceAll("\\s+", " ");

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
                continue;
            }

            if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
                System.out.println("Invalid input. Only alphabets allowed.");
                continue;
            }

            return name;
        }
    }

    public int readChoice(String msg, int min, int max) {
        while (true) {
            int c = readInt(msg);
            if (c >= min && c <= max) return c;
            System.out.println("Invalid choice");
        }
    }
}