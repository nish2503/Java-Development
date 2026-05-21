package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-action")
public class LoginServlet extends HttpServlet {

    public void init() {
        System.out.println("LoginServlet initialized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String remember = request.getParameter("remember");
        
        
        // Validation
        if (username == null || username.isEmpty() ||
            password == null || password.isEmpty()) {

            request.setAttribute("error", "All fields are required");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                   .forward(request, response);
            return;
        }

        try {
            AdminDAO dao = new AdminDAO();
            boolean isValid = dao.validateAdmin(username, password);

            if (isValid) {

                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", username);

                Cookie cookie = new Cookie("rememberUser", username);

                if (remember != null) {
                    cookie.setMaxAge(60 * 60 * 24);
                } else {
                    cookie.setMaxAge(0);
                }

                response.addCookie(cookie);

                // SUCCESS → redirect
                response.sendRedirect("dashboard");

            } else {
                // FAIL → forward
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                       .forward(request, response);
            }
            

        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", "Server error");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp")
                   .forward(request, response);
        }
    }

    public void destroy() {
        System.out.println("LoginServlet destroyed");
    }
}
