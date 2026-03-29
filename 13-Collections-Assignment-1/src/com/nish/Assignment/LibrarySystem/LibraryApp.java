package com.nish.Assignment.LibrarySystem;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputHelper input = new InputHelper(scanner);
        Library library = new Library();

        while (true) {

            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            int roleChoice = input.readChoice("Choose: ", 1, 3);

            if (roleChoice == 3) break;

            User currentUser = (roleChoice == 1) ? new User(1, "Admin", Role.ADMIN) : new User(2, "User", Role.READER);

            while (true) {

                try {
                    if (currentUser.getRole() == Role.ADMIN) {

                        System.out.println("\n--- ADMIN ---");
                        System.out.println("1. Add Book");
                        System.out.println("2. Remove Book");
                        System.out.println("3. View Books");
                        System.out.println("4. Approve Request");
                        System.out.println("5. Logout");

                        int choice = input.readChoice("Enter: ", 1, 5);

                        if (choice == 5) break;

                        switch (choice) {
                            case 1:
                                int id = input.readInt("ID: ");
                                String title = input.readString("Title: ");
                                String author = input.readString("Author: ");
                                int cat = input.readChoice("1.Academic 2.Magazine: ", 1, 2);

                                BookCategory category = (cat == 1) ? BookCategory.ACADEMIC : BookCategory.MAGAZINE;

                                library.addBook(currentUser, new Book(id, title, author, category));
                                break;

                            case 2:
                                library.removeBook(currentUser, input.readInt("Enter ID: "));
                                break;

                            case 3:
                                library.displayBooks();
                                break;

                            case 4:
                                library.approveRequest(currentUser);
                                break;
                        }

                    } else {

                        System.out.println("\n--- USER ---");
                        System.out.println("1. View Books");
                        System.out.println("2. Request Book");
                        System.out.println("3. Return Book");
                        System.out.println("4. Logout");

                        int choice = input.readChoice("Enter: ", 1, 4);

                        if (choice == 4) break;

                        switch (choice) {
                            case 1:
                                library.displayBooks();
                                break;

                            case 2:
                                library.requestBook(currentUser, input.readInt("Enter ID: "));
                                break;

                            case 3:
                                library.returnBook(input.readInt("Enter ID: "));
                                break;
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        System.out.println("System closed.");
        scanner.close();
    }
}