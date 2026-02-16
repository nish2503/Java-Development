package com.nish.ArrayBasics;

public class EnhancedForLoop {
	public static void main(String[] args) {
		int[] arr = {5, 10, 15, 20};
		
		for(int num : arr) {
			num += 5;
		}
		
		System.out.print("Not modified : ");
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
		
		// doesn't modify the values, since they are copies
		
		System.out.println();
		
		System.out.print("Modified : ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] += 5;
		}
		
		for(int num:arr) {
			System.out.print(num + " ");
		}
	}
}
