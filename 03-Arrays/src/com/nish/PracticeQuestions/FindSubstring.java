package com.nish.PracticeQuestions;

import java.util.Scanner;

public class FindSubstring {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter string : ");
		String text = scanner.nextLine();

		System.out.println("Enter substring to find : ");
		String pattern = scanner.nextLine();

		if (text != null && pattern != null 
				&& text.length() > 0 
				&& pattern.length() > 0) {

			int index = findSubstring(text, pattern);

			if (index != -1) {
				System.out.println("Substring found at index : " + index);
			} else {
				System.out.println("Substring not found.");
			}

		} else {
			System.out.println("Enter valid strings!");
		}
		scanner.close();
	}

	public static int findSubstring(String text, String pattern) {

		int n = text.length();
		int m = pattern.length();

		if (m > n)
			return -1;

		for (int i = 0; i <= n - m; i++) {
			int j = 0;
			while (j < m && 
				   text.charAt(i + j) == pattern.charAt(j)) {
				j++;
			}
			if (j == m) {
				return i;
			}
		}
		return -1;
	}
}
