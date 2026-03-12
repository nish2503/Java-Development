package com.nish.Assignment;

public class PasswordPolicyValidator {
	String password;
	PasswordPolicyValidator(String password){
		this.password = password;
	}
	
	public void validate() {
		password = password.trim();
		password = password.replaceAll(" ", "");
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasDigit = false;
		for(char c:password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				hasUpper = true;
			}
			if(Character.isLowerCase(c)) {
				hasLower = true;
			}
			if(Character.isDigit(c)) {
				hasDigit = true;
			}
		}
		
		boolean hasValidLength = password.length() >= 8;
		
		System.out.println("Password: " + password);
        System.out.println("Length valid: " + (hasValidLength ? "Yes" : "No"));
        System.out.println("Contains uppercase: " + (hasUpper ? "Yes" : "No"));
        System.out.println("Contains lowercase: " + (hasLower ? "Yes" : "No"));
        System.out.println("Contains digit: " + (hasDigit ? "Yes" : "No"));
        
        if (hasValidLength && hasUpper && hasLower && hasDigit) {
            System.out.println("\nPassword is VALID");
        } else {
            System.out.println("\nPassword is INVALID");
        }
	}
}
