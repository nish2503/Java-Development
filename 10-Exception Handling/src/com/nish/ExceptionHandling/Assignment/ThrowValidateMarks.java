package com.nish.ExceptionHandling.Assignment;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowValidateMarks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter marks: ");
			int marks = scanner.nextInt();
			if(marks < 0 || marks > 100) {
				System.out.println("Error!");
				throw new IllegalArgumentException("Invalid marks.");
			}
			else {
				System.out.println("Valid Marks.");
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid Input.");
		}
	}

}
