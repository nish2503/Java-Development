package com.nish.whileLoop;

import java.util.Scanner;

public class PerfectNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number : ");
		int number = scanner.nextInt();
		int i = 1;
		int perfectCheck = 0;

		while (i < number) {
			if (number % i == 0) {
				perfectCheck += i;
			}
			i++;
		}
		if (perfectCheck == number) {
			System.out.println("Perfect Number");
		} else {
			System.out.println("Not Perfect Number");
		}
	}

}
