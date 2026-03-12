package com.nish.ExceptionHandling.Assignment;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleCatchStringArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		try {
			
			System.out.println("Enter size of array: ");
			int size = scanner.nextInt();
			scanner.nextLine();
			String[] array = new String[size];
			for(int i=0; i<size; i++) {
				
				System.out.println("Enter string for index " + (i+1) + ": ");
				array[i] = scanner.nextLine();	
				
				if(array[i].isEmpty()) {
					array[i] = null;
				}
			}
			
			System.out.println("Enter index to access: ");
			int index = scanner.nextInt();
			System.out.println("String at index " + index + " is: " + array[index]);
			
			System.out.println("Enter index to access string length: ");
			int lengthIndex = scanner.nextInt();
			System.out.println("String length: " + array[lengthIndex].length());
			break;
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input! Need integer.");
			scanner.nextLine();
			continue;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Index is out of range!");
			scanner.nextLine();
			continue;
		}
		catch(NullPointerException e) {
			System.out.println("Cannot access length of null string!");
		}
		finally {
			System.out.println("Program executed.");
			System.out.println();
		}
		}
	}

}
