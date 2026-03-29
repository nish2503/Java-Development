package com.nish.Learnings;

public class Immutable {
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s);
		System.out.println(s.hashCode());
		s = s + " world";
		System.out.println(s);
		System.out.println(s.hashCode());
	}
}
