package com.nish.ReducedElse;

import java.util.Scanner;

public class StudentReduced {
	private String name;
	private int marks;
	
	StudentReduced(String name, int marks){
		this.name = name;
		this.marks = marks;
	}
	
	public String calculateGrade(int marks) {
		if(marks >= 90) {
			return "A";
		}
		if(marks >= 75){
			return "B";
		}
		if(marks >= 60) {
			return "C";
		}
		if(marks >= 40) {
			return "D";
		}
		return "FAIL";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = scanner.nextLine();
		System.out.println("Enter marks : ");
		int marks = scanner.nextInt();
		StudentReduced s1 = new StudentReduced(name, marks);
		System.out.println("Grade Result : " + s1.calculateGrade(marks));
	}

}
