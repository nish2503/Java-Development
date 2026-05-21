package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-course")
public class DeleteCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int courseId = Integer.parseInt(request.getParameter("id"));

        CourseDAO courseDAO = new CourseDAO();

        if (courseDAO.isCourseRegistered(courseId)) {

            request.setAttribute("error", "Cannot delete. Course has registrations.");

            request.getRequestDispatcher("/WEB-INF/views/error.jsp")
                   .forward(request, response);
            return;
        }

        courseDAO.deleteCourse(courseId);

        response.sendRedirect("courses");
    }
}