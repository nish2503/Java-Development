package com.nish.Assignment.LibrarySystem;

import java.util.*;


public class Library {
	private Set<Book> books = new HashSet<>();
	private Queue<Integer> requestQueue = new LinkedList<>();
	
	public Book findBook(int id) throws BookNotFoundException{
		for(Book b:books) {
			if(b.getId() == id) return b;
		}
		throw new BookNotFoundException("Book not found");
	}
	
	public void addBook(User user, Book book) throws UnauthorizedAccessException{
		if(user.getRole() != Role.ADMIN) {
			throw new UnauthorizedAccessException("Only admins can add books.");
		}
		if(!books.add(book)) {
			throw new IllegalArgumentException("Duplicate Book ID not allowed");
		}	
	}
	
	public void removeBook(User user, int id) throws UnauthorizedAccessException, BookNotFoundException{
		if(user.getRole() != Role.ADMIN) {
			throw new UnauthorizedAccessException("Only admin can remove books.");
		}
		Book b = findBook(id);
		books.remove(b);
		System.out.println("Book ID" + id + " has been removed.");
	}
	
	public void displayBooks() {
		if(books.isEmpty()) {
			System.out.println("No books available");
			return;
		}
		
		List<Book> list = new ArrayList<>(books);
		Collections.sort(list);
		
		for(Book b:list) {
			b.displayBookDetails();
		}
	}
	
	public void requestBook(User user, int id) throws BookNotFoundException {
		Book b = findBook(id);
		if(b.getStatus() == BookStatus.AVAILABLE) {
			requestQueue.add(id);
			b.setStatus(BookStatus.WAITING);
			System.out.println("Request added to queue");
		}
		else {
			throw new BookNotFoundException("Book not available");
		}
	}
	
	public void approveRequest(User user) throws Exception {
        if (user.getRole() != Role.ADMIN) {
            throw new UnauthorizedAccessException("Only admin can approve!");
        }

        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests");
            return;
        }

        int id = requestQueue.poll();
        Book b = findBook(id);

        b.setStatus(BookStatus.ISSUED);
        System.out.println("Request approved. Book issued.");
    }

    public void returnBook(int id) throws Exception {
        Book b = findBook(id);
        b.setStatus(BookStatus.AVAILABLE);
        System.out.println("Book returned");
    }
}
