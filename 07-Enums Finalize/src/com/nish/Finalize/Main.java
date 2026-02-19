package com.nish.Finalize;

public class Main {

	public static void main(String[] args) {
		for(int i=0; i<6; i++) {
			FakeDB db = new FakeDB();
			db = null;
		}
		
		System.gc();
		
		System.out.println("End of main method");
	}

}
