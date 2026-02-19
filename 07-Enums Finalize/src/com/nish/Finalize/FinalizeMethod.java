package com.nish.Finalize;

class Demo{
	@Override
	protected void finalize() throws Throwable{
		// CleanUp Code
		System.out.println("Finalize() Method called");
	}
}

public class FinalizeMethod {

	public static void main(String[] args) {
		Demo obj = new Demo();
		obj = null; // making object eligible for garbage collection
		System.gc(); // suggest JVM to run garbage collection
		System.out.println("End of main method");
	}

}
