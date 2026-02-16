package com.nish.PracticeQuestions;

import java.util.Scanner;

public class ShiftCharOfString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string : ");
		String str = scanner.nextLine();
		System.out.println("Enter number of places to shift by : ");
		int k = scanner.nextInt();

		if (str != null) {
			int n = str.length();
			k = k % n;
			char[] arr = str.toCharArray();
			reverse(arr, 0, k - 1);
			reverse(arr, k, n - 1);
			reverse(arr, 0, n - 1);
			
			String result = new String(arr);
			
			System.out.println("New string is : " + result);
		} else {
			System.out.println("Enter valid string!");
		}
		scanner.close();
	}

	public static void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;
		}
	}

}
