package com.nish.Objects;

public class Test {
	public static void main(String[] args) {
		A obj = new B();
		obj.show();
		System.out.println(obj.x);
//		obj.display(); // cant call because compiler sees A only
		
		((B)obj).display(); // need to typecast to B type
	}
}
