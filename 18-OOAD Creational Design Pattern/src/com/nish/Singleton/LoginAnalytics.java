package com.nish.Singleton;

public class LoginAnalytics {
	private static final LoginAnalytics loginAnalytics = new LoginAnalytics();
	private LoginAnalytics() {
		
	}
	
	public static LoginAnalytics getInstance() {
		return loginAnalytics;
	}
}
