package com.nish.Constructors;

public class Child extends Parent {
	
	int age;
	
	Child(){
		this(10);
		System.out.println("Child default constructor");
	}
	
	Child(int age){
		super("Nishtha");
		this.age = age;
		System.out.println("Child parameterized constructor");
	}
	
	void showDetails() {
		System.out.println("Child's show details method : " + age);
	}
	
	void testDetails() {
		this.showDetails();
		super.showDetails();
		showDetails();
	}
	
}
