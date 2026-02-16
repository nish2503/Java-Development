package com.nish.PracticeQuestions;
import java.util.Scanner;
public class RepetitionOfArrayElement {
	
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
			
			for(int i=0; i<arr.length; i++) {
				int cnt = 0;
				for(int j=0; j<arr.length; j++) {
					if(arr[j] == arr[i]) {
						cnt++;
					}
				}
				System.out.println("Element : " + arr[i] + " Frequency : " + cnt);
			}
		}
		scanner.close();
	}
}
