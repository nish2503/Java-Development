package com.nish.TestAssignment.HospitalRecordSystem;

import java.util.Scanner;

public class HospitalSystem {
	
    Scanner scanner = new Scanner(System.in);
    private Staff[] staffList;
    private int count = 0;
    
    private HospitalMenu menu = new HospitalMenu();

    public HospitalSystem() {

        int size = InputHelper.readPositiveInt(scanner, "Enter number of staff records: ");
        staffList = new Staff[size];
    }

    public void addDoctor() {

        int id = InputHelper.readPositiveInt(scanner, "Enter ID: ");
        String name = InputHelper.readName(scanner, "Enter Name: ");
        String department = InputHelper.readName(scanner, "Enter Department: ");
        String specialization = InputHelper.readName(scanner, "Enter Specialization: ");
        double fee = InputHelper.readPositiveDouble(scanner, "Enter Fee: ");

        staffList[count++] = new Doctor(id, name, department, specialization, fee);
    }


    public void addNurse() {

        int id = InputHelper.readPositiveInt(scanner, "Enter ID: ");
        String name = InputHelper.readName(scanner, "Enter Name: ");
        String dept = InputHelper.readName(scanner, "Enter Department: ");
        String shift = InputHelper.readName(scanner, "Enter Shift: ");
        int ward = InputHelper.readPositiveInt(scanner, "Enter Ward: ");

        staffList[count++] = new Nurse(id, name, dept, shift, ward);
    }
    
    public void displayAllStaff() {

        if(count == 0) {
            System.out.println("No staff records available.");
            return;
        }

        int doctorCount = 0;
        int nurseCount = 0;

        for(int i = 0; i < count; i++) {

            if(staffList[i] instanceof Doctor)
                doctorCount++;

            else if(staffList[i] instanceof Nurse)
                nurseCount++;
        }

        System.out.println("\n--- Staff Record ---");

        for(int i = 0; i < count; i++) {
        	System.out.println();
            staffList[i].displayDetails();
            System.out.println("---------------------");
        }
        
        System.out.println("\nStaff Summary :");
        System.out.println("Total Staff: " + count);
        System.out.println("Total Doctors: " + doctorCount);
        System.out.println("Total Nurses: " + nurseCount);
        System.out.println("---------------------");
    }


    public static void main(String[] args) {
    	
    	HospitalSystem system = new HospitalSystem();
        system.menu.start(system, system.scanner);
    }
}