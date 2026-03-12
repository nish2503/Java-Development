package com.nish.Abstraction.Test;
import java.util.Scanner;
import com.nish.Abstraction.Model.EmergencyPatient;
import com.nish.Abstraction.Model.InPatient;
import com.nish.Abstraction.Model.OutPatient;
import com.nish.Abstraction.Model.Patient;

public class HospitalSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------ HOSPITAL BILLING SYSTEM ------");
        System.out.println("Enter number of patients:");

        int n = readValidInt(scanner);

        Patient[] patients = new Patient[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPatient " + (i + 1) + ":");

            System.out.println("Enter Patient ID (e.g., P1234):");
            String patientId = readValidPatientId(scanner);

            System.out.println("Enter Patient Name:");
            String name = readValidName(scanner);

            System.out.println("Enter Visiting Charges:");
            double visitingCharges = readValidDouble(scanner);

            System.out.println("Enter Medicine Charges:");
            double medicineCharges = readValidDouble(scanner);

            System.out.println("Select Patient Type:");
            System.out.println("1. InPatient");
            System.out.println("2. OutPatient");
            System.out.println("3. EmergencyPatient");

            int choice = readValidChoice(scanner);

            switch (choice) {

                case 1:
                    System.out.println("Enter Room Charges:");
                    double roomCharges = readValidDouble(scanner);

                    patients[i] = new InPatient(patientId, name, visitingCharges, medicineCharges, roomCharges);
                    break;

                case 2:
                    patients[i] = new OutPatient(patientId, name, visitingCharges, medicineCharges);
                    break;

                case 3:
                    System.out.println("Enter Emergency Charges:");
                    double emergencyCharges = readValidDouble(scanner);

                    patients[i] = new EmergencyPatient(patientId, name, visitingCharges, medicineCharges, emergencyCharges);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        System.out.println("\n------ GENERATING BILLS ------");

        for (Patient p : patients) {
        	System.out.println();
            p.generateBill();
            System.out.println();
            System.out.println("-------------------------");
        }

        scanner.close();
    }

    public static int readValidInt(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Invalid input. Enter positive integer:");
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();

            if (value <= 0) {
                System.out.println("Invalid. Enter positive integer:");
                continue;
            }

            return value;
        }
    }

    public static double readValidDouble(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextDouble()) {
                scanner.next();
                System.out.println("Invalid input. Enter positive amount:");
                continue;
            }

            double value = scanner.nextDouble();
            scanner.nextLine();

            if (value <= 0) {
                System.out.println("Invalid. Enter positive amount:");
                continue;
            }

            return value;
        }
    }

    public static int readValidChoice(Scanner scanner) {
        while (true) {
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input. Choose 1, 2 or 3:");
                continue;
            }

            int value = scanner.nextInt();
            scanner.nextLine();

            if (value < 1 || value > 3) {
                System.out.println("Invalid choice. Choose 1, 2 or 3:");
                continue;
            }

            return value;
        }
    }

    public static String readValidPatientId(Scanner scanner) {
        while (true) {
            String id = scanner.nextLine().trim();

            if (!id.matches("^P\\d{4}$")) {
                System.out.println("Invalid ID format. Example: P1234");
                continue;
            }

            return id;
        }
    }

    public static String readValidName(Scanner scanner) {
		while (true) {

			String name = scanner.nextLine().trim();
			
			name = name.replaceAll("\\s+", " ");

			if (name.isEmpty()) {
				System.out.println("Name cannot be empty. Enter again: ");
				continue;
			}

			if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			return name;
		}
	}
}