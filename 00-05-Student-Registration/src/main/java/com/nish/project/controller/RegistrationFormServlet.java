package com.nish.project.controller;

import java.io.IOException;
import java.util.List;

import com.nish.project.dao.CourseDAO;
import com.nish.project.dao.StudentDAO;
import com.nish.project.model.Course;
import com.nish.project.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration-form")
public class RegistrationFormServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> studentList = new StudentDAO().getAllStudents();
        List<Course> courseList = new CourseDAO().getAllCourses();

        request.setAttribute("students", studentList);
        request.setAttribute("courses", courseList);

        request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp")
               .forward(request, response);
    }
}