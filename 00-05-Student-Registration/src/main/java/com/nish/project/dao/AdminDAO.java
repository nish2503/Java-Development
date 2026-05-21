package com.nish.project.dao;

import com.nish.project.util.DBConnection;

import java.sql.*;

public class AdminDAO {

    public boolean validateAdmin(String username, String password) {

        boolean isValid = false;

        try {
            Connection connection = DBConnection.getConnection();
  
            String sql = "SELECT * FROM admin WHERE username=? AND password=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
            	System.out.println("MATCH FOUND");
                isValid = true;
            }
            else {
            	System.out.println("NO MATCH");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
