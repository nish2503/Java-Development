package com.nish.project.util;

import java.sql.*;

public class DBConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/student_course_db";
	private static final String USER = "root";
	private static final String PASSWORD = "Nkbsql0702$$";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB connected");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return connection;
	}
}
