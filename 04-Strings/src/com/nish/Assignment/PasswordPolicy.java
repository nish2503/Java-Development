package com.nish.Assignment;
import java.util.Scanner;

public class PasswordPolicy {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Password: ");
		String code = scanner.nextLine();
		PasswordPolicyValidator checker = new PasswordPolicyValidator(code);
		checker.validate();
		scanner.close();
	}
}
