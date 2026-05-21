package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.CourseDAO;
import com.nish.project.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit-course")
public class EditCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int courseId = Integer.parseInt(request.getParameter("id"));

        CourseDAO courseDAO = new CourseDAO();
        Course course = courseDAO.getCourseById(courseId);

        request.setAttribute("course", course);

        request.getRequestDispatcher("/WEB-INF/views/edit-course.jsp")
               .forward(request, response);
    }
}