package com.nish.Learnings;

public class CallStackExample {
	public static void main(String[] args) {
		System.out.println("main method started");
		methodA();
		System.out.println("main method executed");
	}
	
	public static void methodA() {
		System.out.println("methodA started");
		methodB();
		System.out.println("methodA executed");
	}
	
	public static void methodB() {
		System.out.println("methodB started");
	}
}
