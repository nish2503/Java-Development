package com.nish.project.util;

import java.sql.*;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/student_management";
	private static final String user = "root";
	private static final String password = "Nkbsql0702$$";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
}
