package com.nish.Finalize;

public class FakeDB {
	static int openConnections = 0;
	static final int LIMIT = 3;
	
	public FakeDB() {
		openConnections++;
		System.out.println("Connection opened. Total : " + openConnections);
		
		if(openConnections > LIMIT) {
			System.out.println("!! SYSTEM OVERLOADED !!");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		openConnections--;
		System.out.println("Connection close by GC. Total : " + openConnections);
	}
}
