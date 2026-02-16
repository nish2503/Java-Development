package com.nish.whileLoop;

public class PrintOddNumbers1to100 {
	public static void main(String[] args) {
		int number = 1;
		while(number <= 100) {
			if(number%2 != 0) System.out.println(number);
			number++;
		}
	}
}
