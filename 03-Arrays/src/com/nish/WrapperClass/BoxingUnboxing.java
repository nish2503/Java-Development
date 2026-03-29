package com.nish.WrapperClass;

public class BoxingUnboxing {
	public static void main(String[] args) {
		Integer x = 10;
		Integer y = 10;
		System.out.println(Integer.valueOf(x));
		System.out.println(x==y);
		System.out.println(x.equals(y));
		
		// caching
		Integer m = 200;
		Integer n = 200;
		System.out.println(m==n);
		System.out.println(m.equals(n));
	}
}
