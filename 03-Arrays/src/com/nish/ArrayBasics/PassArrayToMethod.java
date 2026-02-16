package com.nish.ArrayBasics;

public class PassArrayToMethod {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30};
		printArray(arr);
		
		System.out.println();
		
		int[] arr2 = new int[] {100, 200, 300};
		printArray(arr2);
		
		System.out.println();
		
		int[] arr3;
		arr3 = new int[] {1000, 2000, 3000};
		printArray(arr3);
		
		System.out.println();
		
		
	}
	
	public static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
