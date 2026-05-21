package com.nish.project.controller;

import java.io.IOException;

import com.nish.project.dao.CourseDAO;
import com.nish.project.model.Course;
import com.nish.project.util.InputValidator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-course")
public class AddCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String name = InputValidator.validateCourseName(
                            request.getParameter("name"));

            String duration = InputValidator.validateDuration(
                            request.getParameter("duration"));

            double fees = InputValidator.validateFees(
                            Double.parseDouble(
                                    request.getParameter("fees")));

            String trainer = InputValidator.validateTrainer(
                            request.getParameter("trainer"));

            Course course = new Course(name, duration, fees, trainer);

            CourseDAO courseDAO = new CourseDAO();

            courseDAO.addCourse(course);

            response.sendRedirect("courses");

        } catch (NumberFormatException exception) {

            request.setAttribute("error", "Fees must be a valid number.");

            request.getRequestDispatcher("/WEB-INF/views/course-form.jsp")
                   .forward(request, response);

        } catch (Exception exception) {

            request.setAttribute("error", exception.getMessage());

            request.getRequestDispatcher("/WEB-INF/views/course-form.jsp")
                   .forward(request, response);
        }
    }
}