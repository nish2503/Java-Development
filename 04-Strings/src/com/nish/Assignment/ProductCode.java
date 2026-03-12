package com.nish.Assignment;
import java.util.Scanner;

public class ProductCode {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductCodeAnalyzer checker;
		while(true) {
			System.out.println("Enter Product Code (CAT-ITEMCODE-YEAR): ");
			String code = scanner.nextLine();
			checker = new ProductCodeAnalyzer(code);
			
			if(checker.isValid()) {
				break;
			}
			System.out.println("Invalid code. Enter again.");
		}
		
		checker.analyze();
		scanner.close();
	}

}
