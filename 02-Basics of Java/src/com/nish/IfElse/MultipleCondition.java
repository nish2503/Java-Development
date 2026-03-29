package com.nish.IfElse;

public class MultipleCondition {
	public static void main(String[] args) {
		int x = 5;
		if(x>10 || x++<10) {
			System.out.println(x);
		}
		// first false, hence rest checked
		
		int y=5;
		if(y<10 || y++<10) {
			System.out.println(y);
		}
		// first true, rest not executed
		
		int m=5;
		if(m>10 && m++<10) {
			System.out.println(m);
		}
		// first false, rest not executed
		System.out.println(m);
		
		int n=5;
		if(n<10 && n++<10) {
			System.out.println(n);
		}
		// first true, hence rest also checked
	}
}
