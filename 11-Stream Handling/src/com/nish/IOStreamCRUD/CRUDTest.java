package com.nish.IOStreamCRUD;

import java.util.Scanner;

public class CRUDTest {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1 Create");
            System.out.println("2 Read");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter id name marks: ");
                    String data = sc.nextLine();
                    FileCRUD.create(data);
                    break;

                case 2:
                    FileCRUD.read();
                    break;

                case 3:
                    System.out.println("Enter id to update: ");
                    String uid = sc.nextLine();

                    System.out.println("Enter new record: ");
                    String newData = sc.nextLine();

                    FileCRUD.update(uid, newData);
                    break;

                case 4:
                    System.out.println("Enter id to delete: ");
                    String did = sc.nextLine();

                    FileCRUD.delete(did);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}