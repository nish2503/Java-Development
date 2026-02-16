package com.nish.Basics;
import java.util.Scanner;

public class CalculateWaterBill {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter units used :");
		int units = scanner.nextInt();
		
		int meterCharge = 75;
		int charge = 0;
		
		if(units <= 100) {
			charge += units*5;
		}
		else {
			if(units <= 250) {
				charge += units*10;
			}
			else {
				charge += units*20;
			}
		}
		
		System.out.println("Total Water Bill : " + (meterCharge + charge));
		
		scanner.close();
	}

}
