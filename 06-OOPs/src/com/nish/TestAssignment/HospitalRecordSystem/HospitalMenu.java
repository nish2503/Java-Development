package com.nish.TestAssignment.HospitalRecordSystem;

import java.util.Scanner;

public class HospitalMenu {

    public void displayMenu() {

        System.out.println("\n1. Add Doctor");
        System.out.println("2. Add Nurse");
        System.out.println("3. Display Staff");
        System.out.println("4. Exit");
    }

    public void start(HospitalSystem system, Scanner scanner) {

        while(true) {

            displayMenu();

            int choice = InputHelper.readPositiveInt(scanner, "Enter choice: ");

            switch(choice) {

                case 1 : 
                	system.addDoctor();
                	break;
                case 2 : 
                	system.addNurse();
                	break;
                case 3 : 
                	system.displayAllStaff();
                	break;
                case 4 :                     
                	System.out.println("Exiting system...");
                    System.exit(0);
                    break;
                default : 
                	System.out.println("Invalid choice.");
            }
        }
    }
}