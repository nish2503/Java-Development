package com.nish.Assignment.LibrarySystem;

public class User {
	private int id;
	private String name;
	private Role role;
	
	public User(int id, String name, Role role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public Role getRole() {
		return role;
	}
	
	public String getName() {
		return name;
	}
}
