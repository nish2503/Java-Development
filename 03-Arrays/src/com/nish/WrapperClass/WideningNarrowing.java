package com.nish.WrapperClass;

public class WideningNarrowing {
	public static void main(String[] args) {
		// widening
		int x = 10;
		float y = x;
		System.out.println(y);
		
		//narrowing
		float m = 100.5f;
		int n = (int) m;
		System.out.println(n);
	}
}
