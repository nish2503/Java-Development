package com.nish.ExceptionHandling.Assignment;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		try {
			System.out.println("Enter numerator: ");
			int numerator = scanner.nextInt();
			
			System.out.println("Enter denominator: ");
			int denominator = scanner.nextInt();
			
			int answer = numerator/denominator;
			System.out.println("Answer: " + answer);
			break;
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input! Enter integer only.");
			scanner.nextLine();
		}
		catch(ArithmeticException e) {
			System.out.println("Error. Can't divide number by 0!");
		}
		catch(Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
		}
		scanner.close();
	}
}
