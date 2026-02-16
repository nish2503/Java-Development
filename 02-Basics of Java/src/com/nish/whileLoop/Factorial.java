package com.nish.whileLoop;
import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number : ");
		int number = scanner.nextInt();
		int factorial = 1, i = 1;
		while(i <= number) {
			factorial = factorial*i;
			i++;
		}
		
		System.out.println("Factorial is : " + factorial);
		scanner.close();
	}

}
