package com.nish.TestAssignment.StudentEnrollmentSystem;

import java.util.Scanner;

public class StudentSystem {

    private Scanner scanner = new Scanner(System.in);
    private Student[] students;
    private int count = 0;

    private StudentMenu menu = new StudentMenu();

    public StudentSystem() {

        int size = InputHelper.readPositiveInt(scanner, "Enter number of students: ");

        students = new Student[size];
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void addRegularStudent() {

        int id = InputHelper.readPositiveInt(scanner, "Enter Student ID: ");

        String name = InputHelper.readName(scanner, "Enter Name: ");

        String course = InputHelper.readName(scanner, "Enter Course: ");

        double fee = InputHelper.readPositiveDouble(scanner, "Enter Tuition Fee: ");

        students[count++] = new RegularStudent(id, name, course, fee);
    }

    public void addScholarshipStudent() {

        int id = InputHelper.readPositiveInt(scanner, "Enter Student ID: ");

        String name = InputHelper.readName(scanner, "Enter Name: ");

        String course = InputHelper.readName(scanner, "Enter Course: ");

        double scholarship = InputHelper.readPositiveDouble(scanner, "Enter Scholarship Amount: ");

        students[count++] = new ScholarshipStudent(id, name, course, scholarship);
    }

    public void displayStudents() {

        if(count == 0) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- Student Records ---");

        for(int i = 0; i < count; i++) {

            students[i].displayDetails();
            System.out.println("-------------------");
        }
    }

    public static void main(String[] args) {

        StudentSystem system = new StudentSystem();
        system.menu.start(system, system.scanner);
    }
}