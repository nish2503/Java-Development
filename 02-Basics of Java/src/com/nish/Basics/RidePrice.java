package com.nish.Basics;
import java.util.Scanner;

public class RidePrice {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter height :");
		int height = scanner.nextInt();
		System.out.println("Enter age :");
		int age = scanner.nextInt();
		System.out.println("Do you want photos ?");
		String input = scanner.next();
		
		boolean wantPhotos = input.equalsIgnoreCase("yes") 
								|| input.equalsIgnoreCase("y")
								|| input.equals(1);
		
		int bill = 0;
		
		if(height > 120) {
			System.out.println("You can ride");
			if(age < 12) {
				bill += 5;
			}
			else if (age <18) {
				bill += 7;
			}
			else {
				bill += 12;
			}
			
			if(wantPhotos) {
				bill += 3;
			}
			
			System.out.println("Total bill is $" + bill);
		}
		else {
			System.out.println("You can't ride");
		}
		
		scanner.close();
	}

}
