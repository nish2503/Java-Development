package com.nish.Assignment;

public class FileNameValidator {
	String fileName;
	FileNameValidator(String fileName){
		this.fileName = fileName;
	}
	
	public void validate() {
		boolean isPdf = fileName.toLowerCase().endsWith(".pdf");
        int dotPos = fileName.lastIndexOf('.');
        String extension = fileName.substring(dotPos + 1);
        String name = fileName.substring(0, dotPos);
        name = name.replace("_", " ");
        String formattedName = name.toUpperCase();
        boolean containsFinal = name.toLowerCase().contains("final");

        System.out.println("File Name: " + name);
        System.out.println("Extension: " + extension);
        System.out.println("Is PDF file: " + (isPdf ? "Yes" : "No"));
        System.out.println("Contains 'final': " + (containsFinal ? "Yes" : "No"));
        System.out.println("Formatted Name: " + formattedName);
	}
}
