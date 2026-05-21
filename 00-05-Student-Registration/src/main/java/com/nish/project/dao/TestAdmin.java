package com.nish.project.dao;

public class TestAdmin {

    public static void main(String[] args) {

        AdminDAO dao = new AdminDAO();

        boolean result = dao.validateAdmin("admin", "admin123");

        if (result) {
            System.out.println("LOGIN SUCCESS");
        } else {
            System.out.println("LOGIN FAILED");
        }
    }
}