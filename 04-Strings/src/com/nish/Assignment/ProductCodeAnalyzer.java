package com.nish.Assignment;

public class ProductCodeAnalyzer {
	String code;
	
	ProductCodeAnalyzer(String code){
		this.code = code;
	}
	
	public boolean isValid() {
		String[] parts = code.split("-");
		return parts.length == 3;
	}
	
	public void analyze() {
		code = code.trim();
		code = code.replaceAll(" ", "");
		code = code.toUpperCase();
		String[] parts = code.split("-");
		
		String category = parts[0];
		String productName = parts[1];
		String manufacturingYear = parts[2];
		
		String modifiedCode = code.replaceAll("-", " ");
		
		System.out.println("Category: " + category);
		System.out.println("Product: " + productName);
		System.out.println("Year: " + manufacturingYear);
		System.out.println("Starts with TV: " + (productName.startsWith("TV") ? "Yes":"No"));
		System.out.println("Ends with 2023: " + (code.endsWith("2023") ? "Yes" : "No"));
		System.out.println("Modified Code: " + modifiedCode);
		System.out.println("Position of first hyphen: " + code.indexOf("-"));
		
	}
}
