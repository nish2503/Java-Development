package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();

        if (studentDAO.isStudentRegistered(studentId)) {

            request.setAttribute("error", "Cannot delete. Student is registered in a course.");

            request.getRequestDispatcher("/WEB-INF/views/error.jsp")
                   .forward(request, response);
            return;
        }

        studentDAO.deleteStudent(studentId);

        response.sendRedirect("students");
    }
}