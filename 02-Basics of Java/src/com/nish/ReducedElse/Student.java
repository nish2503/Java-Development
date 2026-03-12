package com.nish.ReducedElse;

import java.util.Scanner;

public class Student {
	private String name;
	private int marks;
	
	Student(String name, int marks){
		this.name = name;
		this.marks = marks;
	}
	
	public String calculateGrade(int marks) {
		if(marks >= 90) {
			return "A";
		}
		else if(marks >= 75){
			return "B";
		}
		else if(marks >= 60) {
			return "C";
		}
		else if(marks >= 40) {
			return "D";
		}
		else {
			return "FAIL";
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = scanner.nextLine();
		System.out.println("Enter marks : ");
		int marks = scanner.nextInt();
		Student s1 = new Student(name, marks);
		System.out.println("Grade Result : " + s1.calculateGrade(marks));
	}

}
