package com.nish.ExceptionHandling.TryCatchBlocks;

import java.util.Scanner;

public class MultipleCatchBlocks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String s = scanner.nextLine();
		
		if (s.isEmpty()) {
		    s = null;   // manually convert empty input to null
		}
		
		try {
			System.out.println("Length of string: " + s.length());
		}
		catch(NullPointerException e) {
			System.out.println("Child exception");
		}
		catch(Exception e) {
			System.out.println("Parent Exception");
		}
	}

}
