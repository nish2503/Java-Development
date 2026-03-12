package com.nish.Assignment;

public class EmailAnalyzerCheck {
	String mail;
	EmailAnalyzerCheck(String mail){
		this.mail = mail;
	}
	
	public void trimSpaces() {
		mail = mail.trim();
		mail = mail.replaceAll(" ", "");
	}
	
	public boolean checkSymbol() {
		return mail.contains("@");
	}
	
	private String getUsername() {
		int pos = mail.indexOf("@");
		return mail.substring(0, pos);
	}
	
	private String getDomain() {
		int pos = mail.indexOf("@");
		return mail.substring(pos+1);
	}
	
	private int usernameLength(String username) {
		return username.length();
	}
	
	private boolean hasDigit(String username) {
		return username.matches(".*\\d.*");
	}
	
	private String replaceDots(String username) {
        return username.replace('.', '_');
    }
	
	public void analyze() {
		trimSpaces();
		if(!checkSymbol()) {
			System.out.println("Invalid mail. No @ present.");
		}
		
		mail = mail.toLowerCase();

        String username = getUsername();
        String domain = getDomain();

        System.out.println("Username: " + username);
        System.out.println("Domain: " + domain);
        System.out.println("Total characters in username: " + usernameLength(username));
        System.out.println("Contains digits: " + (hasDigit(username) ? "Yes" : "No"));
        System.out.println("Modified username: " + replaceDots(username));
	}
}
