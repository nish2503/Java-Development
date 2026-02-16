package com.nish.PracticeQuestions;
import java.util.Scanner;
public class FindMaxInArray {
	
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
			
			int maxNum = arr[0];
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i] > maxNum) {
					maxNum = arr[i];
				}
			}
			
			System.out.println("Maximum Number is : " + maxNum);
		}
		scanner.close();
	}
}
