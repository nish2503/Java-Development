package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit-student")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentById(studentId);

        request.setAttribute("student", student);

        request.getRequestDispatcher("/WEB-INF/views/edit-student.jsp")
               .forward(request, response);
    }
}