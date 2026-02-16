package com.nish.PracticeQuestions;
import java.util.Scanner;
public class PeakElementOfArray {
	
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
			
			int peak = -1;
			
			if(size == 1) {
				peak = arr[0];
			}
			
			else if(arr[0] > arr[1]) {
				peak = arr[0];
			}
			
			else if(arr[size - 1] > arr[size - 2]) {
				peak = arr[size-1];
			}
			
			else {
				for(int i=1; i<size-1; i++) {
					if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
						peak = arr[i];
					}
				}
			}
			
			System.out.println("Peak is : " + peak);
		}
		scanner.close();
	}
}
