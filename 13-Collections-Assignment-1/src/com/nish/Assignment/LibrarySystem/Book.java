package com.nish.Assignment.LibrarySystem;

import java.util.Objects;
import java.lang.Comparable;

public class Book implements Comparable<Book> {
	private int id;
	private String title;
	private String author;
	private BookStatus status;
	private BookCategory category;
	
	public Book(int id, String title, String author, BookCategory category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status.AVAILABLE;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	
	public BookStatus getStatus() {
		return status;
	}
	
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	
	public void displayBookDetails() {
		System.out.println("Id: " + id);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Category: " + category);
		System.out.println("Issue Status: " + status);
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof Book)) return false;
		Book book = (Book) o;
		return id == book.id;
	}
	
	@Override 
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public int compareTo(Book other) {
		return this.id - other.id;
	}
}
