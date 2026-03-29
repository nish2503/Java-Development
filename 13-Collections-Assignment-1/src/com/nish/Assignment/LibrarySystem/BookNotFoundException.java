package com.nish.Assignment.LibrarySystem;

public class BookNotFoundException extends Exception {
	public BookNotFoundException(String msg){
		super(msg);
	}
}

class BookNotAvailableException extends Exception{
	public BookNotAvailableException(String msg) {
		super(msg);
	}
}

class UnauthorizedAccessException extends Exception{
	public UnauthorizedAccessException(String msg) {
		super(msg);
	}
}
