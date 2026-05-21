package com.nish.project.controller;

import java.io.IOException;
import java.util.List;

import com.nish.project.dao.CourseDAO;
import com.nish.project.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class ViewCoursesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Course> courseList = new CourseDAO().getAllCourses();

        request.setAttribute("courses", courseList);

        request.getRequestDispatcher("/WEB-INF/views/course-list.jsp")
               .forward(request, response);
    }
}