package com.nish.project.controller;

import java.io.IOException;
import java.util.List;

import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/students")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            res.sendRedirect("login");
            return;
        }

        List<Student> list = new StudentDAO().getAllStudents();
        req.setAttribute("students", list);

        req.getRequestDispatcher("/WEB-INF/views/student-list.jsp")
           .forward(req, res);
    }
}