package com.nish.Constructors;

public class Parent {
	
	String name;
	
	Parent(){
		this("Parent-1");
		System.out.println("Parent default constructor");
	}
	
	Parent(String name){
		this.name = name;
		System.out.println("Parent parameterized constructor");
	}
	
	void showDetails() {
		System.out.println("Parent's show details method : " + name);
	}
	
}
