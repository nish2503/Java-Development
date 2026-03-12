package com.nish.ExceptionHandling.Throwable;
import java.util.Scanner;

public class PrintError {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter numerator: ");
			int numerator = scanner.nextInt();
			System.out.println("Enter denominator: ");
			int denominator = scanner.nextInt();
			int divide = numerator/denominator;
			System.out.println("Answer is: " + divide);
		}
		catch(Throwable t){
			System.out.println(t.getMessage());
		}
	}

}
