package com.nish.ArrayOfObjects.Test;

import java.util.Scanner;

import com.nish.ArrayOfObjects.Model.Course;
import com.nish.ArrayOfObjects.Model.OnlineCourse;
import com.nish.ArrayOfObjects.Model.RegularCourse;

public class CourseTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------WELCOME TO COURSES------");
		System.out.println("Enter number of courses: ");
		int n = readValidInt(scanner);
		scanner.nextLine();

		Course[] courses = new Course[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nCourse " + (i + 1) + ":");

			System.out.println("Enter Course ID (eg : XY123) : ");
			String courseId = readValidId(scanner);
			System.out.println("Enter Course Name: ");
			String courseName = readValidName(scanner);

			System.out.println("Select Course Type");
			System.out.println("1. Regular Course");
			System.out.println("2. Online Course");

			int choice = readValidChoice(scanner);

			switch (choice) {

			case 1:
				System.out.println("Enter regular fee: ");
				double regularFee = readValidDouble(scanner);
				scanner.nextLine();
				courses[i] = new RegularCourse(courseId, courseName, regularFee);
				break;

			case 2:
				System.out.println("Enter online fee: ");
				double onlineFee = readValidDouble(scanner);
				System.out.println("Enter platform fee: ");
				double platformFee = readValidDouble(scanner);
				scanner.nextLine();
				courses[i] = new OnlineCourse(courseId, courseName, onlineFee, platformFee);
				break;

			default:
				System.out.println("Invalid input.");
				break;
			}
		}

		System.out.println("\n------Course Details------");

		for (Course course : courses) {
			course.courseDetails();
			System.out.println("Course Fee: " + course.calculateFee());
			System.out.println("---------------------------");
		}

		System.out.println("Total Courses: " + Course.counter);
		System.out.println("---------------------------");
	}

	public static int readValidInt(Scanner scanner) {
		while (true) {
			if (!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid input. Enter integer: ");
				continue;
			}
			int value = scanner.nextInt();

			if (value <= 0) {
				System.out.println("Invalid. Enter positive number: ");
				continue;
			}

			return value;
		}
	}

	public static String readValidId(Scanner scanner) {

		while (true) {

			String courseId = scanner.nextLine().trim();

			if (!courseId.matches("^[A-Z]{2}\\d{3}$")) {
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			return courseId;
		}
	}

	public static String readValidName(Scanner scanner) {
		while (true) {
			String name = scanner.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Name cannot be empty. Enter again: ");
				continue;
			}

			name = name.replaceAll("\\s+", " ");

			if (!name.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
				System.out.println("Invalid input. Enter again: ");
				continue;
			}

			return name;
		}
	}
	
	public static int readValidChoice(Scanner scanner) {
		while(true) {
			if(!scanner.hasNextInt()) {
				scanner.next();
				System.out.println("Invalid input type. Enter integer: ");
				continue;
			}
			
			int value = scanner.nextInt();
			
			if(value < 1 || value > 2) {
				System.out.println("Invalid. Choose either 1 or 2: ");
				continue;
			}
			
			return value;
		}
	}
	
	public static double readValidDouble(Scanner scanner) {
		while(true) {
			if(!scanner.hasNextDouble()) {
				scanner.next();
				System.out.println("Invalid input type. Enter double: ");
				continue;
			}
			
			double value = scanner.nextDouble();
			
			if(value <= 0) {
				System.out.println("Invalid input. Enter positive value: ");
				continue;
			}
			
			return value;
		}
	}
}
