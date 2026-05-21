package com.nish.project.util;

import java.sql.Connection;

public class TestDB {

    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILED");
        }
    }
}