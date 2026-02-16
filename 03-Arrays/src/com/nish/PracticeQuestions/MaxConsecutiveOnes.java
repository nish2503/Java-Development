package com.nish.PracticeQuestions;

import java.util.Scanner;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter size of array : ");
		int size = scanner.nextInt();

		if (size > 0) {

			int[] arr = new int[size];
			System.out.println("Enter binary array elements (0 or 1) : ");

			for (int i = 0; i < size; i++) {
				arr[i] = scanner.nextInt();
			}

			int maxCount = 0;
			int currentCount = 0;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 1) {
					currentCount++;
					maxCount = Math.max(maxCount, currentCount);
				} else {
					currentCount = 0;
				}
			}
			System.out.println("Maximum consecutive 1s : " + maxCount);

		} else {
			System.out.println("Enter valid size!");
		}
		scanner.close();
	}
}