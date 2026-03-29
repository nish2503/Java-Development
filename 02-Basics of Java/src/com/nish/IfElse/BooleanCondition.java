package com.nish.IfElse;

public class BooleanCondition {
	public static void main(String[] args) {
		
//		COMPILE TIME ERROR
//		if(5) {
//			System.out.println("Hi");
//		}
		int age = 5;
		if(age>18) 
			System.out.println("Eligible");
			System.out.println("Always runs");
			
		int x = 5;
		if(x>0)
			if(x<10)
				System.out.println("Between");
			else
				System.out.println("Else");
		
		String s = "hello";
		
//		if(s) {
//			System.out.println("hi");
//		}
		
		
	}
}
