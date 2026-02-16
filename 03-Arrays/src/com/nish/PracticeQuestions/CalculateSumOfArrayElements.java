package com.nish.PracticeQuestions;
import java.util.Scanner;
public class CalculateSumOfArrayElements {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int size = scanner.nextInt();
		if(size > 0) {
			int[] arr = new int[size];
			
			System.out.println("Enter array elements : ");
			
			for(int i=0; i < size; i++) {
				arr[i] = scanner.nextInt();
			}
			
			int sum = 0;
			
			for(int i=0; i<arr.length; i++) {
				sum += arr[i];
			}
			
			System.out.println("Sum of Array Elements is : " + sum);
		}
		scanner.close();
	}
}
