package com.nish.PracticeQuestions;
import java.util.Scanner;

public class ReadDisplayArrayElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of array : ");
		int size = scanner.nextInt();
		if(size > 0) {
			int[] arr = new int[size];
			
			for(int i=0; i < size; i++) {
				arr[i] = scanner.nextInt();
			}
			
			for(int i=0; i<size; i++) {
				System.out.print(arr[i] + " ");
			}
		}
		else {
			System.out.println("Give positive integer");
		}
		scanner.close();
	}
}
