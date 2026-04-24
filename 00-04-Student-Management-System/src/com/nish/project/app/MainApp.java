package com.nish.project.app;

import java.sql.Connection;
import java.sql.SQLException;

import com.nish.project.util.DBUtil;

public class MainApp {
	public static void main(String[] args) {
		try(Connection connection = DBUtil.getConnection()){
			System.out.println("Connection successful!");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		}
	}
}
