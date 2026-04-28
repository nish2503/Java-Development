package com.nish.project.app;

import java.util.Scanner;

import com.nish.project.exception.DAOException;
import com.nish.project.model.Student;
import com.nish.project.service.StudentService;
import com.nish.project.util.InputHelper;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Register Course");
            System.out.println("3. View All Students");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Update Student Details");
            System.out.println("6. Update Course Fee");
            System.out.println("7. Cancel Course Registration");
            System.out.println("8. Delete Student");
            System.out.println("9. High Paying Students");
            System.out.println("10. Course-wise Report");
            System.out.println("11. Exit");

            int choice = InputHelper.readInt(scanner, "Enter choice: ");

            try {

                switch (choice) {

                    case 1:
                        int id = InputHelper.readNewStudentId(scanner, service);
                        String name = InputHelper.readString(scanner, "Enter Name: ");
                        int age = InputHelper.readInt(scanner, "Enter Age: ");
                        int branchId = InputHelper.readInt(scanner, "Enter Branch ID: ");

                        service.addStudent(new Student(id, name, age, branchId));
                        break;

                    case 2:
                        int studentId = InputHelper.readInt(scanner, "Enter Student ID: ");
                        int courseId = InputHelper.readInt(scanner, "Enter Course ID: ");
                        double fee = InputHelper.readDouble(scanner, "Enter Fee: ");

                        service.registerCourse(studentId, courseId, fee);
                        break;

                    case 3:
                        service.viewAllStudentsWithRegistrations();
                        break;

                    case 4:
                        int searchId = InputHelper.readInt(scanner, "Enter Student ID: ");
                        service.searchStudentRegistrationById(searchId);
                        break;

                    case 5:
                    	int updateStudentId = InputHelper.readExistingStudentId(scanner, service);
                        if (updateStudentId == 0) break;
                        String newName = InputHelper.readString(scanner, "Enter New Name: ");
                        int newBranch = InputHelper.readInt(scanner, "Enter New Branch ID: ");

                        service.updateStudentDetails(updateStudentId, newName, newBranch);
                        break;

                    case 6:
                    	int updateStudentCid = InputHelper.readExistingStudentId(scanner, service);
                        if (updateStudentCid == 0) break;
                        int updateCourseId = InputHelper.readInt(scanner, "Enter Course ID: ");
                        double newFee = InputHelper.readDouble(scanner, "Enter New Fee: ");

                        service.updateCourseFee(updateStudentCid, updateCourseId, newFee);
                        break;

                    case 7:
                    	int cancelStudentId = InputHelper.readExistingStudentId(scanner, service);
                        if (cancelStudentId == 0) break;
                        int cancelCourseId = InputHelper.readInt(scanner, "Enter Course ID: ");

                        service.cancelCourse(cancelStudentId, cancelCourseId);
                        break;

                    case 8:
                        int deleteId = InputHelper.readInt(scanner, "Enter Student ID: ");
                        service.deleteStudent(deleteId);
                        break;

                    case 9:
                        double amount = InputHelper.readDouble(scanner, "Enter minimum fee: ");
                        service.highPaying(amount);
                        break;

                    case 10:
                        service.courseReport();
                        break;

                    case 11:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (Exception e) {
                System.out.println("Something went wrong. Please try again.");
            }
        }
    }
}