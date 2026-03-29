package com.nish.Constructors;

public class privateConstructor {
	String name;
	private privateConstructor(String name){
		this.name = name;
	}
	
	public static privateConstructor getObject(String name) {
		return new privateConstructor(name);
	}
}

class Test{
	public static void main(String[] args) {
		privateConstructor p = privateConstructor.getObject("nish");
	}
}
