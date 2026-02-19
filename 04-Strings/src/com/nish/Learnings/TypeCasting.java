package com.nish.Learnings;

public class TypeCasting {

	public static void main(String[] args) {
		
		// implicit (widening)
		int a = 5;
		double b = a;
		System.out.println("Implicit typecasting Integer a to Double : " + b);
		
		// explicit (narrowing)
		double c = 5.5;
		int d = (int) c;
		System.out.println("Explicit typecasting Double c to Integer : " + d);
		
		
	}

}
